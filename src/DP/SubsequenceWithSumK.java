package DP;

public class SubsequenceWithSumK {

    int[][] memo;

    public boolean checkSubsequenceSum(int[] arr, int k) {
        memo = new int[arr.length][k + 1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= k; j++) {
                memo[i][j] = -1;
            }
        }
        return solve(arr, k, 0);

    }

    public boolean solve(int arr[], int k, int idx) {
        if (k == 0) return true;
        if (idx >= arr.length || k < 0) return false;
        if (memo[idx][k] != -1) return (memo[idx][k] == 1);
        boolean take = solve(arr, k - arr[idx], idx + 1);
        boolean notTake = solve(arr, k, idx + 1);
        boolean ans = (take || notTake);
        if (ans) memo[idx][k] = 1;
        else memo[idx][k] = 0;
        return ans;
    }
}