class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0] == b[0]){
              return  Integer.compare(b[1],a[1]);
            }
            return Integer.compare(a[0],b[0]);
        });
        for(int[] interval : intervals){
            pq.offer(interval);
        }
        int cnt = 1;
        int[] node = pq.poll();
        while(!pq.isEmpty()){
            if(pq.peek()[0] >= node[0] && pq.peek()[1] <= node[1]){
                pq.poll();
            }
            else{
                cnt++;
                node = pq.poll();
            }
        }
        return cnt;
    }
}