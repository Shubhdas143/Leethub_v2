class Solution {

    Integer[] dp;
    int MOD = 1_000_000_007;
    int[] last;

    public int distinctSubseqII(String s) {

        dp = new Integer[s.length() + 1];
        last = new int[26];

        Arrays.fill(last, -1);

        return (solve(s.length(), s) - 1 + MOD) % MOD;
    }

    private int solve(int i, String s) {

        if (i == 0) {
            return 1;
        }

        if (dp[i] != null) {
            return dp[i];
        }

        long ans = (2L * solve(i - 1, s)) % MOD;

        char ch = s.charAt(i - 1);

        int prev = -1;

        for (int j = i - 2; j >= 0; j--) {
            if (s.charAt(j) == ch) {
                prev = j;
                break;
            }
        }

        if (prev != -1) {
            ans = (ans - solve(prev, s) + MOD) % MOD;
        }

        return dp[i] = (int) ans;
    }
}