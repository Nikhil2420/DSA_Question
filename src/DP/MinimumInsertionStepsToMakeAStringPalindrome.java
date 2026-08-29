package DP;

public class MinimumInsertionStepsToMakeAStringPalindrome {

    int memo[][];

    public int minInsertions(String s) {
        int n = s.length();
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }

        return solve(s, 0, n - 1);
    }

    public int solve(String s, int i, int j) {
        if (i >= j) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        if (s.charAt(i) == s.charAt(j)) {
            return memo[i][j] = solve(s, i + 1, j - 1);
        }
        /*
         If s[i] != s[j], we have 2 choices

         1. Match s[i] by inserting it at the right:
            "abc" → "abca" → solve("bc")
         => solve(i + 1, j)

        2. Match s[j] by inserting it at the left:
           "abc" → "cabc" → solve("ab")
           => solve(i, j - 1)

         */
        return memo[i][j] = 1 + Math.min(solve(s, i + 1, j), solve(s, i, j - 1));
    }
}