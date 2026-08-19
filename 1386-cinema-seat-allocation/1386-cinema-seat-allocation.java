class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map=new HashMap<>();
        for(int[]row:reservedSeats){
            map.computeIfAbsent(row[0],k->new HashSet<>()).add(row[1]);
        }
        int ans=0;
        for(int val:map.keySet()){
            Set<Integer>cur=map.get(val);
            //contains 2,6
            if(!cur.contains(2)&&!cur.contains(3)&&!cur.contains(4)&&!cur.contains(5)){
                cur.add(2);
                cur.add(3);
                cur.add(4);
                cur.add(5);
                ans++;
            }else if(!cur.contains(4)&&!cur.contains(5)&&!cur.contains(6)&&!cur.contains(7)){
                cur.add(4);
                cur.add(5);
                cur.add(6);
                cur.add(7);
                ans++;
            }
            if(!cur.contains(4)&&!cur.contains(5)&&!cur.contains(6)&&!cur.contains(7)){
                cur.add(4);
                cur.add(5);
                cur.add(6);
                cur.add(7);
                ans++;
            }else if(!cur.contains(6)&&!cur.contains(7)&&!cur.contains(8)&&!cur.contains(9)){
                cur.add(6);
                cur.add(7);
                cur.add(8);
                cur.add(9);
                ans++;
            }
        }
        int notReserved=n-map.size();
        return ans+(notReserved*2);
    }
}