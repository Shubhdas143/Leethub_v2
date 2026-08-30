class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length, max = Integer.MIN_VALUE, maxIdx = -1, min = Integer.MAX_VALUE, minIdx = -1;
        for(int i = 0; i < n; i++) {
            if(nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
            if(nums[i] < min) {
                min = nums[i];
                minIdx = i;
            }
        }
        int left = -1, right = -1;
        if(minIdx < maxIdx) {
            left = minIdx;
            right = maxIdx;
        } else {
            left = maxIdx;
            right = minIdx;
        }

        return Math.min(left + 1 + (n - right), Math.min(n - left, right + 1));
    }
}