class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        final int MOD = 1_000_000_007;
        int n = s.length();

        long[] pow10 = new long[n + 1];
        pow10[0] = 1;

        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }
        int[] idx = new int[n + 1];
        long[] val = new long[n + 1];
        long[] total = new long[n + 1];

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';

            if (digit != 0) {
                cnt++;
                val[cnt] = (val[cnt - 1] * 10 + digit) % MOD;
                total[cnt] = total[cnt - 1] + digit;
            }

            idx[i + 1] = cnt;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            int left = idx[l];
            int right = idx[r + 1];
            if (left == right) {
                ans[i] = 0;
                continue;
            }

            int len = right - left;
            long number = (val[right] - (val[left] * pow10[len]) % MOD) % MOD;

            if (number < 0)
                number += MOD;

            long sum = total[right] - total[left];
            ans[i] = (int) ((number * sum) % MOD);
        }

        return ans;
    }
}