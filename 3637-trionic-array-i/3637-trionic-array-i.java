class Solution {
    public boolean isTrionic(int[] nums) {

        int n = nums.length;
        int i = 1;

        // 1️⃣ Increasing part
        while (i < n && nums[i] > nums[i - 1]) {
            i++;
        }

        // must have at least one increase
        if (i == 1 || i == n) return false;

        // 2️⃣ Decreasing part
        while (i < n && nums[i] < nums[i - 1]) {
            i++;
        }

       
        if (i == n) return false;

        while (i < n && nums[i] > nums[i - 1]) {
            i++;
        }

        return i == n;
    }
}
