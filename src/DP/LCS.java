package DP;

public class LCS {
    int memo[][];

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        return solve(text1, text2, m - 1, n - 1);
    }

    public int solve(String str1, String str2, int i, int j) {
        if (i < 0 || j < 0) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        if (str1.charAt(i) == str2.charAt(j)) {
            memo[i][j] = 1 + solve(str1, str2, i - 1, j - 1);
            return memo[i][j];
        }
        memo[i][j] = Math.max(solve(str1, str2, i - 1, j), solve(str1, str2, i, j - 1));
        return memo[i][j];
    }
}