class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray())
            freq[ch - 'a']++;

        // Fix the middle element
        int n = s.length(), mid = -1;
        if (n % 2 == 0)
        {
            for (int num : freq)
            {   
                // no palindrome possible
                if (num % 2 == 1)
                    return "";
            }
        }
        else
        {
            boolean odd = false;
            for (int i = 0; i < 26; i++)
            {
                if (freq[i] % 2 == 1)
                {
                    if (odd)
                        return "";
                    odd = true;
                    mid = i;
                }
            }
        }

        char[] ans = new char[n];
        if (n % 2 == 1)
        {
            ans[n / 2] = (char) ('a' + mid);
            freq[ans[n / 2] - 'a']--;
        }

        // match the longest possible prefix
        int index = 0;
        while (index < n / 2)
        {
            if (freq[target.charAt(index) - 'a'] == 0)
                break;

            ans[index] = target.charAt(index);
            ans[n - index - 1] = ans[index];
            freq[ans[index] - 'a'] -= 2;
            index++;
        }

        if (index == n / 2 && String.valueOf(ans).compareTo(target) > 0)
            return String.valueOf(ans);

        if (index == n / 2 && n / 2 > 0)
        {
            freq[ans[n / 2 - 1] - 'a'] += 2;
            index--;
        }

        // reduce the length of the matched prefix so that we get a strictly greater string than target
        while (index >= 0 && higher(index, target, freq) == -1)
        {
            index--;
            if (index >= 0)
                freq[target.charAt(index) - 'a'] += 2;
        }

        if (index == -1)
            return "";

        // make the first unmatched character strictly greater than in target
        ans[index] = (char) ('a' + higher(index, target, freq));
        ans[n - index - 1] = ans[index];
        freq[ans[index] - 'a'] -= 2;

        // make the rest of the indices in increasing order
        for (int i = index + 1; i < n / 2; i++)
        {
            for (int ch = 0; ch < 26; ch++)
            {
                if (freq[ch] > 0)
                {
                    ans[i] = (char) ('a' + ch);
                    ans[n - i - 1] = ans[i];
                    freq[ch] -= 2;
                    break;
                }
            }
        }

        return String.valueOf(ans);
    }

    private int higher(int index, String target, int[] freq)
    {
        int ch = target.charAt(index) - 'a';

        for (int i = ch + 1; i < 26; i++)
        {
            if (freq[i] > 0)
                return i;
        }

        return -1;
    }
}