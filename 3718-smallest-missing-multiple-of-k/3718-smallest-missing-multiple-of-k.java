class Solution {

    public int missingMultiple(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();

        for (int num : nums) set.add(num);

        int num = 1;

        while (true) {
            if (!set.contains(k * num))
                return k * num;

            num++;
        }
    }
}