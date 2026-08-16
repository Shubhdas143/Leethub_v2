class Solution {
    public boolean stoneGameIX(int[] stones) {
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        for (int val : stones) {
            int r = val % 3;
            if (r == 0) cnt0++;
            else if (r == 1) cnt1++;
            else cnt2++;
        }
        if (cnt0 % 2 == 0) {
            return cnt1 >= 1 && cnt2 >= 1;
        }
        return Math.abs(cnt1 - cnt2) > 2;
    }
}