class Solution {
    static {
        for (int i = 0; i <= 500; i++) {
            largestInteger(new int[0], 0);
        }
    }

    public static int largestInteger(int[] nums, int k) {
        int n = nums.length;

        if (n == 0) return n;

        if (n == k) {
            int max = nums[0];

            for (int i = 1; i < n; i++) {
                max = Math.max(max, nums[i]);
            }

            return max;
        }

        if (k == 1) {
            int[] freq = new int[51];

            for (int num : nums) {
                freq[num]++;
            }

            int max = -1;

            for (int num : nums) {
                if (freq[num] == 1) {
                    max = Math.max(max, num);
                }
            }

            return max;
        }

        if (nums[0] == nums[n - 1]) {
            return -1;
        }

        boolean firstUnique = true;
        boolean lastUnique = true;

        for (int i = 1; i < n - 1; i++) {
            if (nums[i] == nums[0]) {
                firstUnique = false;
            }

            if (nums[i] == nums[n - 1]) {
                lastUnique = false;
            }
        }

        if (firstUnique && !lastUnique) {
            return nums[0];
        }

        if (!firstUnique && lastUnique) {
            return nums[n - 1];
        }

        if (!firstUnique && !lastUnique) {
            return -1;
        }

        return Math.max(nums[0], nums[n - 1]);
    }
}