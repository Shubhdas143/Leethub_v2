class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        String str = s.substring(0, n / 2);
        char[] ch = str.toCharArray();
        Arrays.sort(ch);

        String first = new String(ch);
        StringBuilder res = new StringBuilder();

        res.append(first);

        if ((n & 1) == 1) {
            res.append(s.charAt(n / 2));
        }

        res.append(new StringBuilder(first).reverse());

        return res.toString();
    }
}