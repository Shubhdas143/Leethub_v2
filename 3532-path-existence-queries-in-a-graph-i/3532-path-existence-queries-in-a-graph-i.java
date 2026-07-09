class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        boolean[] res = new boolean[queries.length];
        int color = 0,idx = 0;
        int[] colorArray = new int[n];
        for(int i = 1 ; i < n ; i++){
            colorArray[i] = nums[i] - nums[i - 1] <= maxDiff ? color : ++color;
        }
        for(int[] q : queries){
                res[idx++] = colorArray[q[0]] == colorArray[q[1]];
        }
        return res;
    }
}