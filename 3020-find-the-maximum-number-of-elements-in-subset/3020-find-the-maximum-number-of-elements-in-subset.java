class Solution {
    public int maximumLength(int[] nums) {
        int ans = 1;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
            max = Math.max(max, num);
        }

        if (map.containsKey(1)) {
            ans = map.get(1);
            if (ans % 2 == 0)
                ans--;
            map.remove(1);
        }

        outer: for (Integer num : map.keySet()) {
            int freq = map.get(num);

            if (freq <= 1)
                continue;

            int count = 2;
            while (num <= max) {
                num *= num;
                freq = Math.min(freq, map.getOrDefault(num, 0));

                if (freq >= 1)
                    count += 2;

                ans = Math.max(ans, count - 1);

                if (freq <= 1)
                    continue outer;
            }
        }

        return ans;
    }
}