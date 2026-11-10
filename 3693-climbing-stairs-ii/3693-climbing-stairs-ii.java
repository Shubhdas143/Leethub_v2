class Solution {
    public int climbStairs(int n, int[] costs) {
        int INF = Integer.MAX_VALUE / 2;
        int p3 = INF, p2 = INF, p1 = 0;
        for (int i = 1; i <= n; i++) {
            int best = Math.min(p1 + 1, Math.min(p2 + 4, p3 + 9));
            int cur = best + costs[i - 1];
            p3 = p2;
            p2 = p1;
            p1 = cur;
        }
        return p1;
    }
}