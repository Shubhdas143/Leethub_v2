class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
      Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        List<List<Integer>> list = new ArrayList<>();
        if (arr.length < 2) return list;
        int diff=0;
        for (int i = 0; i < arr.length - 1; i++) {
                min = Math.min(min, arr[i + 1] - arr[i]);
            }
        for(int i=0;i<arr.length-1;i++)
        {
            diff=arr[i+1] - arr[i];
            // min = Math.min(min, arr[i + 1] - arr[i]);
            if(diff==min)
            { List<Integer> inner = new ArrayList<>();
                inner.add(arr[i]);
                inner.add(arr[i+1]);
                list.add(inner);
            }
        }
        return list;
    }
}