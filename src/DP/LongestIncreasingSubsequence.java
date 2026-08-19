package DP;

public class LongestIncreasingSubsequence {

    int memo[][];

    public int lis(int arr[]) {
        int n = arr.length;
        memo = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                memo[i][j] = -1;
            }
        }
        return solve(arr, 0, -1);

    }

    public int solve(int arr[], int currIdx, int prevIdx) {
        if (currIdx >= arr.length) return 0;
        if (memo[currIdx][prevIdx + 1] != -1) return memo[currIdx][prevIdx + 1];
        int take = 0;
        if (prevIdx == -1 || arr[currIdx] > arr[prevIdx]) {
            take = 1 + solve(arr, currIdx + 1, currIdx);
        }
        int notTake = solve(arr, currIdx + 1, prevIdx);
        memo[currIdx][prevIdx + 1] = Math.max(take, notTake);
        return memo[currIdx][prevIdx + 1];
    }
}