class Solution {
    List<Integer>[] graph;
    boolean[] visited;
    int vertices;
    int degreeSum;

    public int countCompleteComponents(int n, int[][] edges) {
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                vertices = 0;
                degreeSum = 0;
                dfs(i);
                int edgeCount = degreeSum / 2;
                if (edgeCount == vertices * (vertices - 1) / 2) {
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int node) {
        visited[node] = true;
        vertices++;
        degreeSum += graph[node].size();

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}