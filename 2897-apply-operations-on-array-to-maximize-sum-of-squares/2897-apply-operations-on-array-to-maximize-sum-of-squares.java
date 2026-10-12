class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] count = new int[32];
        int mod = (int) (1e9 + 7);
        for (int num : nums){
            for (int i = 0; i < 32; ++i)
                count[i] += num >> i & 1;   
        }
        long ans = 0;
        for (int i = 0; i < k; ++i){
            int c = 0;
            for (int j = 0; j < 32; ++j){
                if (count[j] == 0) continue;
                c |= 1 << j;
                --count[j];
            }
            ans = (ans + 1L * c * c) % mod;
        }
        return (int) ans;
    }
}