class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1 || n == 1)
            return 0;
            
        int arr[][] = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = grid.get(i).get(j);
            }
        }
        arr = updateMatrix(arr);
        
        int low = 0, high = (n - 1) * 2;
        int mid = 0; 
        int result = mid;
        while(low <= high) {
            mid = (high - low) / 2 + low;
            if(dfs(arr,0, 0, mid, n, new boolean[n][n])) {
                result = mid;
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return result;
    }

    public int[][] updateMatrix(int[][] matrix) {
        int n = matrix.length;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                matrix[row][col] ^= 1;
                if (matrix[row][col] == 1) {
                    matrix[row][col] = Integer.MAX_VALUE / 2;
                }
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 1; col < n; col++) {
                matrix[row][col] = Math.min(matrix[row][col], matrix[row][col - 1] + 1);
            }
            for (int col = n - 2; col >= 0; col--) {
                matrix[row][col] = Math.min(matrix[row][col], matrix[row][col + 1] + 1);
            }
        }

        for (int col = 0; col < n; col++) {
            for (int row = 1; row < n; row++) {
                matrix[row][col] = Math.min(matrix[row][col], matrix[row - 1][col] + 1);
            }
            for (int row = n - 2; row >= 0; row--) {
                matrix[row][col] = Math.min(matrix[row][col], matrix[row + 1][col] + 1);
            }
        }

        return matrix;
    }
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    boolean dfs(int arr[][], int r, int c, int mid, int n, boolean[][] visited) {
        if(visited[r][c] || arr[r][c] < mid) return false;
        if(r == n - 1 && c == n - 1) return true;

        visited[r][c] = true;
        for(int i = 0; i < 4; i++) {
            int x = r + dx[i];
            int y = c + dy[i];

            if(x == -1 || y == -1 || x == n || y == n) continue;
            if(dfs(arr, x, y, mid, n, visited)) return true;
        }
        return false;
    }

}