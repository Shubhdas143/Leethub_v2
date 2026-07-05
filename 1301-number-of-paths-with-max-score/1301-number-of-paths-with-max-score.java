class Solution {
    int memoPath[][];
    int memoSum[][];
    int MOD = 1000000007;
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        memoPath = new int[n][n];
        memoSum = new int[n][n];
        for(int arr[]: memoPath){
            Arrays.fill(arr, -2);
        }
        int result [] = solve(n-1, n-1, board);
        if(result[0] == -1) return new int[]{0, 0};
        return result;
    }
    public int[] solve(int row, int col, List<String> board){

        if(row < 0 || col < 0){
            return new int[]{-1, 0};
        }

        char ch = board.get(row).charAt(col);
        if(ch == 'X'){
            return new int[]{-1, 0};
        }

        if(row == 0 && col == 0){
            return new int[]{0, 1};
        }

        if(memoPath[row][col] != -2) {
            return new int[]{memoSum[row][col], memoPath[row][col]};
        }

        int up[] = solve(row, col-1, board);
        int left[] = solve(row-1, col, board);
        int diag[] = solve(row-1, col-1, board);

        int max = Math.max(up[0], Math.max(left[0], diag[0]));
        if(max == -1){
            memoSum[row][col] = -1;
            memoPath[row][col] = 0;
            return new int[]{-1, 0};
        }
        int paths = 0;
        if(up[0] == max){
            paths = (paths + up[1]) % MOD;
        }
        if(left[0] == max){
            paths = (paths + left[1]) % MOD;
        }
        if(diag[0] == max){
            paths = (paths + diag[1]) % MOD;
        }
        int value = (ch == 'S') ? 0 : (ch - '0');
        memoPath[row][col] = paths;
        memoSum[row][col] = max + value;
        return new int[]{memoSum[row][col], memoPath[row][col]};
    }
}