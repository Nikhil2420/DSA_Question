package DP;

import java.util.Arrays;

public class LongestStringChain {

    int[][] memo;

    public int longestStrChain(String[] words) {
        int n = words.length;
        memo = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                memo[i][j] = -1;
            }
        }
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        return solve(words, 0, -1);
    }

    public int solve(String[] words, int currIndex, int prevIndex) {
        if (currIndex >= words.length) return 0;
        if (memo[currIndex][prevIndex + 1] != -1) return memo[currIndex][prevIndex + 1];
        int take = 0;
        if (prevIndex == -1 || (isPredecessor(words[prevIndex], words[currIndex]))) {
            take = 1 + solve(words, currIndex + 1, currIndex);
        }
        int notTake = solve(words, currIndex + 1, prevIndex);
        return memo[currIndex][prevIndex + 1] = Math.max(take, notTake);
    }

    public boolean isPredecessor(String prevWord, String currWord) {
        if (currWord.length() - prevWord.length() != 1) return false;
        int i = 0;
        int j = 0;

        while (i < prevWord.length() && j < currWord.length()) {

            if (prevWord.charAt(i) == currWord.charAt(j)) {
                i++;
            }

            j++;
        }
        return (i == prevWord.length());
    }
}