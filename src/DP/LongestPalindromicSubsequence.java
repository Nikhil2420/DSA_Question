package DP;

public class LongestPalindromicSubsequence {

    int[][] memo;

    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        String str = sb.toString();
        int n = s.length();
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        return lcs(s, str, n - 1, n - 1);
    }

    public int lcs(String s, String str, int i, int j) {
        if (i < 0 || j < 0) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        if (s.charAt(i) == str.charAt(j)) {
            return memo[i][j] = 1 + lcs(s, str, i - 1, j - 1);
        }

        return memo[i][j] = Math.max(lcs(s, str, i - 1, j), lcs(s, str, i, j - 1));
    }
}