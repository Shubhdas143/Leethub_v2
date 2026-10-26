class Solution {
    public int countIslands(int[][] grid, int k) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int divisibleIslandsCount = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] > 0) {
                    int islandRemainder = dfs(grid, r, c, m, n, k);
                    if (islandRemainder == 0) {
                        divisibleIslandsCount++;
                    }
                }
            }
        }
        return divisibleIslandsCount;
    }

    private int dfs(int[][] grid, int r, int c, int m, int n, int k) {
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] <= 0) {
            return 0;
        }

        int totalRemainder = grid[r][c] % k;
        grid[r][c] = -1; // Mark as visited in-place

        totalRemainder = (totalRemainder + dfs(grid, r - 1, c, m, n, k)) % k; // Up
        totalRemainder = (totalRemainder + dfs(grid, r + 1, c, m, n, k)) % k; // Down
        totalRemainder = (totalRemainder + dfs(grid, r, c - 1, m, n, k)) % k; // Left
        totalRemainder = (totalRemainder + dfs(grid, r, c + 1, m, n, k)) % k; // Right

        return totalRemainder;
    }
}