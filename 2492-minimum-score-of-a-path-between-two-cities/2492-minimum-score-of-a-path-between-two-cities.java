class Solution {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();

        for (int[] e : roads) {
            g[e[0]].add(new int[]{e[1], e[2]});
            g[e[1]].add(new int[]{e[0], e[2]});
        }

        boolean[] vis = new boolean[n + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        vis[1] = true;

        int ans = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int[] cur : g[u]) {
                int v = cur[0], w = cur[1];
                ans = Math.min(ans, w);

                if (!vis[v]) {
                    vis[v] = true;
                    q.offer(v);
                }
            }
        }

        return ans;
    }
}