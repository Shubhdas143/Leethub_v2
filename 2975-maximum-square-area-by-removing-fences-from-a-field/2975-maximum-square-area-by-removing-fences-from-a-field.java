import java.util.*;

class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        List<Integer> hList = new ArrayList<>();
        for (int h : hFences) hList.add(h);
        hList.add(1);
        hList.add(m);

        List<Integer> vList = new ArrayList<>();
        for (int v : vFences) vList.add(v);
        vList.add(1);
        vList.add(n);

        Set<Integer> stt = new HashSet<>();
        long ans = 0;

        for (int i = 0; i < hList.size(); i++) {
            for (int j = i + 1; j < hList.size(); j++) {
                stt.add(Math.abs(hList.get(j) - hList.get(i)));
            }
        }

        for (int i = 0; i < vList.size(); i++) {
            for (int j = i + 1; j < vList.size(); j++) {
                int val = Math.abs(vList.get(j) - vList.get(i));
                if (stt.contains(val)) {
                    ans = Math.max(ans, val);
                }
            }
        }

        if (ans == 0) {
            return -1;
        }

        long MOD = 1_000_000_007;
        return (int) ((ans * ans) % MOD);
    }
}