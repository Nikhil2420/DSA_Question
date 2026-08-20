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
                    int len=j-i+1;
                    if (len > maxLen) {
                        maxLen =len;
                        startPoint = i;
                    }
                }
            }
        }
        return s.substring(startPoint, startPoint + maxLen);

    }

    public boolean isPalindrome(int i, int j, String str) {
        if (i >= j) return true;
        if (str.charAt(i) != str.charAt(j)) return false;
        if (memo[i][j] != -1) return (memo[i][j] == 1);
        boolean check = isPalindrome(i + 1, j - 1, str);
        if (check) memo[i][j] = 1;
        memo[i][j] = 0;
        return check;
    }
}