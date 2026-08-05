class Solution {
    List<Integer> result;

    public List<Integer> remainingMethods(int n, int k, int[][] in) {
        List<List<Integer>> adj = new ArrayList<>();
        result = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < in.length; i++) {
            adj.get(in[i][0]).add(in[i][1]);
        }
        boolean infected[] = new boolean[n];
        DFS(infected, k, adj);
        for (int i = 0; i < n; i++) {
            if (!infected[i]) {
                for (int cur : adj.get(i)) {
                    if (infected[cur]) {
                        Adder(result, n);
                        return result;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!infected[i]) {
                result.add(i);
            }
        }

        return result;
    }

    void DFS(boolean[] in, int node, List<List<Integer>> adj) {
        in[node] = true;
        List<Integer> path = adj.get(node);
        for (int nei : path) {
            if (!in[nei]) {
                DFS(in, nei, adj);
            }
        }
    }

    void Adder(List<Integer> result, int n) {
        int i = 0;
        while (i < n) {
            result.add(i);
            i++;
        }
    }
}