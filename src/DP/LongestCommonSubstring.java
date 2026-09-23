package DP;

public class LongestCommonSubstring {

    int[][][] memo;

    public int longCommSubstr(String s1, String s2) {

        int n1 = s1.length();
        int n2 = s2.length();
        memo = new int[n1][n2][Math.max(n1, n2) + 1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                for (int k = 0; k < Math.max(n1, n2) + 1; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }
        return solve(s1, s2, n1 - 1, n2 - 1, 0);

    }

    public int solve(String s1, String s2, int i, int j, int cnt) {
        if (i < 0 || j < 0) return cnt;
        if (memo[i][j][cnt] != -1) return memo[i][j][cnt];
        int match = cnt;
        if (s1.charAt(i) == s2.charAt(j)) {
            match = solve(s1, s2, i - 1, j - 1, cnt + 1);
        }

        int skip1 = solve(s1, s2, i, j - 1, 0);
        int skip2 = solve(s1, s2, i - 1, j, 0);
        return memo[i][j][cnt] = Math.max(match, Math.max(skip1, skip2));
    }
}