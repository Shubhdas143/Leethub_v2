class Solution {
    public int longestSubsequence(int[] nums) {

        int xor = 0;
        int countZero = 0;

        for (int num : nums) {
            xor ^= num;

            if (num == 0) {
                countZero++;
            }
        }

        if (xor != 0) {
            return nums.length;
        }

        if (countZero == nums.length) {
            return 0;
        }

        return nums.length - 1;
    }
}