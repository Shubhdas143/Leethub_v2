class Solution {
    public int minimumPushes(String word) {
        int freq[] = new int[26];

        for (int i = 0; i < word.length(); i++) {
            freq[word.charAt(i) - 'a']++;
        }

        countSort(freq);

        int j = 25;
        int cnt = 0;
        int ans = 0;

        while (j >= 0) {
            int t = freq[j];

            if (t > 0)
                cnt++;

            if (cnt <= 8) {
                ans += t;
            } else if (cnt <= 16) {
                ans += t * 2;
            } else if (cnt <= 24) {
                ans += t * 3;
            } else {
                ans += t * 4;
            }

            j--;
        }

        return ans;
    }

    public void countSort(int[] nums) {
        int max = 0;

        for (int i = 0; i < 26; i++) {
            max = Math.max(nums[i], max);
        }

        int freq[] = new int[max + 1];

        for (int i = 0; i < 26; i++) {
            freq[nums[i]]++;
        }

        int j = 0;

        for (int i = 0; i <= max; i++) {
            while (freq[i] > 0) {
                nums[j] = i;
                freq[i]--;
                j++;
            }
        }
    }
}