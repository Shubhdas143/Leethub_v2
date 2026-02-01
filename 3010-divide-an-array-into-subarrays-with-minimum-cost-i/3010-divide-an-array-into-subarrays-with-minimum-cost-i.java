class Solution {
    public int minimumCost(int[] nums) {
        int ans = 0, n = nums.length;
        ans+=nums[0];
        int f = Integer.MAX_VALUE, s = Integer.MAX_VALUE;
        for(int i=1;i<n;i++) {
            if(nums[i]<f) {
                s = f;
                f = nums[i];
            }else if(nums[i]>=f && nums[i]<s) {
                s = nums[i];
            }
        }
        return ans+f+s;
    }
}