package DP;

public class EditDistance {

    int memo[][];

    public int minDistance(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                memo[i][j] = -1;
            }
        }
        return solve(word1.length() - 1, word2.length() - 1, word1, word2);
    }

    public int solve(int i, int j, String word1, String word2) {
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;
        if (memo[i][j] != -1) return memo[i][j];

        if (word1.charAt(i) == word2.charAt(j)) {
            memo[i][j] = solve(i - 1, j - 1, word1, word2);
            return memo[i][j];
        }
        int insert = 1 + solve(i, j - 1, word1, word2);
        int delete = 1 + solve(i - 1, j, word1, word2);
        int replace = 1 + solve(i - 1, j - 1, word1, word2);
        memo[i][j] = Math.min(insert, Math.min(replace, delete));
        return memo[i][j];
    }
}