class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int edge[]:edges) {
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];
            adj.get(u).add(new int[]{v,wt});
            adj.get(v).add(new int[]{u,2*wt});
        }

        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0});

        while(!pq.isEmpty()) {
            int pair[]=pq.poll();
            int wt=pair[0];
            int node=pair[1];

            if(node==n-1) return wt;

            for(int neibors[]:adj.get(node)) {
                int nei=neibors[0];
                int distance=neibors[1];

                if(wt+distance < dist[nei]) {
                    dist[nei]=wt+distance;
                    pq.offer(new int[]{dist[nei],nei});
                }
            }
        }
 return -1;
    }
}