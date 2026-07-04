class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        Set<Character> window = new HashSet<>();
           while (right < s.length()) {
            char currentChar = s.charAt(right);
            while (window.contains(currentChar)) {
                window.remove(s.charAt(left));
                left++;
            }
            window.add(currentChar);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
         return maxLength;
    }
}
