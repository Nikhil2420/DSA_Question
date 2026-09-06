package DP;

public class DistinctSubsequences {


    int[][] memo;

    public int numDistinct(String s, String t) {
        memo = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                memo[i][j] = -1;
            }
        }
        return solve(s, t, 0, 0);
    }

    public int solve(String s, String t, int idx, int j) {
        if (j == t.length()) return 1;
        if (idx == s.length()) return 0;
        if (memo[idx][j] != -1) return memo[idx][j];
        int take = 0;
        if (s.charAt(idx) == t.charAt(j)) {
            take = solve(s, t, idx + 1, j + 1);
        }
        int notTake = solve(s, t, idx + 1, j);

        return memo[idx][j] = (take + notTake);
    }
}