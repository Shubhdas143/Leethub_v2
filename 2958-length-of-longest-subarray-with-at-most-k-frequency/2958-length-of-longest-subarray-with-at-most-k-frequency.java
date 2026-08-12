class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int left = 0;
        int n = nums.length;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int x = nums[i];
            map.put(x, map.getOrDefault(x, 0) + 1);
            while(map.containsKey(x) && map.get(x) > k) {
                int ele = nums[left];
                map.put(ele, map.get(ele) - 1);
                if(map.get(ele) == 0) map.remove(ele);
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}