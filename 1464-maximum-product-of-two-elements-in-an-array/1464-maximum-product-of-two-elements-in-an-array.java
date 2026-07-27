class Solution {
    public int maxProduct(int[] nums) {
        int max = -501, max2 = -502;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max2 = max;
                max = nums[i];
            } else if (nums[i] > max2) {
                max2 = nums[i];
            }
        }

        return (max - 1) * (max2 - 1);
    }
}