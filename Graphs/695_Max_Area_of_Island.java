class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    maxArea = Math.max(maxArea, dfs(i, j, grid, vis));
                }
<<<<<<< HEAD
            }
        }
        return maxArea;
    }
    static int dfs(int row, int col, int[][] grid, boolean[][] vis) {
        vis[row][col] = true;
        int area = 1;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            if (nrow >= 0 && nrow < grid.length &&
                ncol >= 0 && ncol < grid[0].length &&
                grid[nrow][ncol] == 1 && !vis[nrow][ncol]) {
                area += dfs(nrow, ncol, grid, vis);
            }
        }
        return area;
=======
            }
        }
        return maxArea;
>>>>>>> 0a44279b17f08d638fb347d9d9a0579151a59ff1
    }
    static int dfs(int row, int col, int[][] grid, boolean[][] vis) {
        vis[row][col] = true;
        int area = 1;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            if (nrow >= 0 && nrow < grid.length &&
                ncol >= 0 && ncol < grid[0].length &&
                grid[nrow][ncol] == 1 && !vis[nrow][ncol]) {
                area += dfs(nrow, ncol, grid, vis);
            }
        }
        return area;
    }
}
