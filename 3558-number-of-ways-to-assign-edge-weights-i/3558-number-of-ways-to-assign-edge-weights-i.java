class Solution {
    private static final int MOD = 1_000_000_007;

    private int power(long a, long b) {
        long ans = 1;
        a %= MOD;

        while (b > 0) {
            if ((b & 1) == 1) {
                ans = (ans * a) % MOD;
            }

            a = (a * a) % MOD;
            b >>= 1;
        }

        return (int) ans;
    }

    private int dfs(int node, int parent, List<List<Integer>> adj) {
        int ans = 0;

        for (int child : adj.get(node)) {
            if (child != parent) {
                ans = Math.max(ans, 1 + dfs(child, node, adj));
            }
        }

        return ans;
    }

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 2;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int depth = dfs(1, -1, adj);

        return power(2, depth - 1);
    }
}