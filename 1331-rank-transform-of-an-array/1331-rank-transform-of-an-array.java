class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        Integer[] ordered = new Integer[n];
        for(int i = 0; i < n; i++){
            ordered[i] = i;
        }
        Arrays.sort(ordered, (Integer a, Integer b)->Integer.compare(arr[a], arr[b]));
        int[] ans = new int[n];
        for(int i = 0, rank = 1; i < n; rank++){
            int j = i;
            while(j < n && arr[ordered[i]] == arr[ordered[j]]){
                ans[ordered[j++]] = rank;
            }
            i = j;
        }
        return ans;
    }
}