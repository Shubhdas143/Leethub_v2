class Solution {
    public int minimumCost(int[] cost) {
        int n = cost.length;
        int totalCost = 0;
        int freeCost = 0;

        int ans = 0;

        cost = Arrays.stream(cost)
                .boxed()
                .sorted((a, b) -> b - a)
                .mapToInt(Integer::intValue)
                .toArray();

        for (int i : cost) {
            totalCost += i;
        }

        for (int i = 2; i < n; i += 3) {
            freeCost += cost[i];
        }

        ans = totalCost - freeCost;
        return ans;
    }
}