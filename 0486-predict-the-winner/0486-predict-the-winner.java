class Solution {
    public boolean predictTheWinner(int[] nums) {
        return getNetScore(nums, 0, nums.length - 1) >= 0;
    }
    
    private int getNetScore(int[] nums, int i, int j) {
        if (i == j) 
            return nums[i];
    
        
        int pickLeft = nums[i] - getNetScore(nums, i + 1, j);
        int pickRight = nums[j] - getNetScore(nums, i, j - 1);
        
        return Math.max(pickLeft, pickRight);
    }
}