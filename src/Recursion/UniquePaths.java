package Recursion;

public class UniquePaths {

    int[][] memo;

    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        return solve(0, 0, m, n);
    }

    public int solve(int i, int j, int m, int n) {
        if (i >= m || j >= n) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        if (i == m - 1 && j == n - 1) return 1;

        int down = solve(i + 1, j, m, n);
        int right = solve(i, j + 1, m, n);
        memo[i][j] = (down + right);
        return memo[i][j];
    }
}