package DP;

public class DeleteOperationForTwoStrings {

    int[][] memo;

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        return solve(word1, word2, 0, 0);
    }

    public int solve(String word1, String word2, int i, int j) {
        if (i >= word1.length()) return word2.length() - j;
        if (j >= word2.length()) return word1.length() - i;
        if (memo[i][j] != -1) return memo[i][j];
        if (word1.charAt(i) == word2.charAt(j)) {
            return solve(word1, word2, i + 1, j + 1);
        }
        int op1 = 1 + solve(word1, word2, i + 1, j);
        int op2 = 1 + solve(word1, word2, i, j + 1);
        return memo[i][j] = Math.min(op1, op2);
    }
}