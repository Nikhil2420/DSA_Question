package DP;

public class ValidParenthesisString {

    int[][] memo;

    public boolean checkValidString(String s) {
        memo = new int[s.length()][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= s.length(); j++) {
                memo[i][j] = -1;
            }
        }
        return solve(s, 0, 0);
    }

    public boolean solve(String s, int idx, int cnt) {
        if (cnt < 0) return false;
        if (idx >= s.length()) return (cnt == 0);
        if (memo[idx][cnt] != -1) {
            return (memo[idx][cnt] == 1);
        }
        char ch = s.charAt(idx);
        if (ch == '(') {
            boolean openParenthesis = solve(s, idx + 1, cnt + 1);
            updateMemo(openParenthesis, idx, cnt);
            return openParenthesis;
        }

        if (ch == ')') {
            boolean closeParenthesis = solve(s, idx + 1, cnt - 1);
            updateMemo(closeParenthesis, idx, cnt);
            return closeParenthesis;
        }

        boolean astrickPossibilities = (solve(s, idx + 1, cnt + 1) || solve(s, idx + 1, cnt - 1) || solve(s, idx + 1, cnt));
        updateMemo(astrickPossibilities, idx, cnt);
        return astrickPossibilities;
    }

    public void updateMemo(boolean res, int idx, int cnt) {
        if (res) memo[idx][cnt] = 1;
        else memo[idx][cnt] = 0;
    }
}