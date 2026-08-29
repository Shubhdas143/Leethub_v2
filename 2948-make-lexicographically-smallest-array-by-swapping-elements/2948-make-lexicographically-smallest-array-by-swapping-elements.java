class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        HashMap<Integer, Integer> group = new HashMap<>();
        HashMap<Integer, Integer> j_idx = new HashMap<>();

        int[] ans = new int[n];

        int grp = 0;
        group.put(sorted[0], grp);
        j_idx.put(grp, 0);

        for(int i=1;i<n;i++){
            if(sorted[i] - sorted[i-1] > limit){
                grp++;
                j_idx.put(grp, i);
            }

            group.put(sorted[i], grp);
        }

        int i = 0;

        while(i < n){
            int currgrp = group.get(nums[i]);
            int j = j_idx.get(currgrp);

            ans[i] = sorted[j];
            j_idx.put(currgrp, j + 1);
            i++;
        }

        return ans;
    }
}