class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        if (n <= 200) {
            Arrays.sort(nums);
            int res = 0;
            for (int i = 0; i < (n >> 1); i++)
                res = Math.max(res, nums[n - 1 - i] + nums[i]);
            return res;
        }

        int max = 0;
        for (int num : nums)
            max = Math.max(max, num);

        int[] freq = new int[max + 1];
        for (int num : nums)
            freq[num]++;

        int i = 0, j = max;
        while (i <= max && freq[i] == 0) i++;
        while (j >= 0 && freq[j] == 0) j--;

        int res = 0;
        for (int k = nums.length / 2; k > 0; k--) {
            res = Math.max(res, i + j);
            freq[i]--;
            freq[j]--;

            if (freq[i] == 0)
                while (i <= max && freq[i] == 0) i++;

            if (freq[j] == 0)
                while (j >= 0 && freq[j] == 0) j--;
        }
        return res;
    }
}
