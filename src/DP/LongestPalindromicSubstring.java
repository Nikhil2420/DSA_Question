package DP;

public class LongestPalindromicSubstring {

    int memo[][];

    public String getLongestPal(String s) {
        int n = s.length();
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }

        int startPoint = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isPalindrome(i, j, s)) {
                    int len = j - i + 1;
                    if (len > maxLen) {
                        maxLen = len;
                        startPoint = i;
                    }
                }
            }
        }
        return s.substring(startPoint, startPoint + maxLen);

    }

    public boolean isPalindrome(int i, int j, String s) {
        if (i >= j) return true;
        if (memo[i][j] != -1) return (memo[i][j] == 1);
        boolean val = false;
        if (s.charAt(i) == s.charAt(j)) {
            val = isPalindrome(i + 1, j - 1, s);
        }
        if (val) memo[i][j] = 1;
        memo[i][j] = 0;
        return val;
    }
}