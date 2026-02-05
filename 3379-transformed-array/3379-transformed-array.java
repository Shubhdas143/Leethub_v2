class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                ans[i] = nums[(nums[i] + i) % n];
            } else if (nums[i] < 0) {
                int freq = (Math.abs(i + nums[i]) + n - 1) / n;
                ans[i] = nums[(i + nums[i] + freq * n) % n];
            } else {
                ans[i] = nums[i];
            }
        }
        return ans;
    }
}