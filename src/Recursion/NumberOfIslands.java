package Recursion;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    //all connected island for this i,j and marking it '0'
                    solve(grid, i, j, m, n);
                }
            }
        }
        return ans;
    }

    public void solve(char grid[][], int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') return;
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
        }
        solve(grid, i, j + 1, m, n);//forward horizontal
        solve(grid, i, j - 1, m, n);//backward horizontal
        solve(grid, i + 1, j, m, n);//downward vertical
        solve(grid, i - 1, j, m, n);//upward vertical
    }
}