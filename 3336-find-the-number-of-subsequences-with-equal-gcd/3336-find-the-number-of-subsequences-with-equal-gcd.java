class Solution {
    long mod = 1_000_000_007; 
    int gcd(int a, int b) {
        if(b == 0) return a; 
        return gcd(b, a % b); 
    }
    public int subsequencePairCount(int[] nums) {
        // need a dp 
        long[][] dp = new long[202][202];
        int n = nums.length; 
        dp[0][0] = 1; // base case 

        int[][] gcdDP = new int[201][201]; 
        for(int i = 0; i <= 200; i++) {
            for(int j = 0; j <= 200; j++) gcdDP[i][j] = gcd(i, j); 
        }

        for(int i = 0; i < n; i++) {
            // g1 seq 
            long[][] nextDP = new long[201][201]; 
            for(int g1 = 0; g1 <= 200; g1++) {
                // g2 seq 
                for(int g2 = 0; g2 <= 200; g2++) {
                    long cur = dp[g1][g2]; 
                    // skip 
                    nextDP[g1][g2] = (nextDP[g1][g2] + cur) % mod; 
                    // add to g1 
                    int new_g1 = gcdDP[g1][nums[i]];
                    nextDP[new_g1][g2] = (nextDP[new_g1][g2] + cur) % mod; 
                    // add to g2 
                    int new_g2 = gcdDP[g2][nums[i]]; 
                    nextDP[g1][new_g2] = (nextDP[g1][new_g2] + cur) % mod; 
                }
            }

            for(int x = 0; x < 201; x++) {
                for(int j = 0; j < 201; j++) {
                    dp[x][j] = nextDP[x][j]; 
                }
            }
        } 

        // compute ans for last index, & g, g 
        long ans = 0; 
        for(int g = 1; g <= 200; g++) {
            ans = (ans + dp[g][g]) % mod; 
        }
        return (int) ans; 
    }
}