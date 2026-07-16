class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int mx = 0;

        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, nums[i]);
            nums[i] = gcd(mx, nums[i]);
        }

        Arrays.sort(nums);

        int left = 0, right = n - 1;
        long ans = 0;

        while (left < right) {
            ans += gcd(nums[left], nums[right]);
            left++;
            right--;
        }

        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}