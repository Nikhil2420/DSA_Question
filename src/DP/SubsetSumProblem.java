package DP;

public class SubsetSumProblem {

    static int[][] memo;

    public static boolean isSubsetSum(int arr[], int sum) {
        memo = new int[arr.length][sum + 1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= sum; j++) {
                memo[i][j] = -1;
            }
        }
        return solve(arr, sum, 0);
    }

    public static boolean solve(int arr[], int sum, int idx) {
        if (sum == 0) return true;
        if (idx >= arr.length || sum < 0) return false;
        if (memo[idx][sum] != -1) return (memo[idx][sum] == 1);
        boolean take = solve(arr, sum - arr[idx], idx + 1);
        boolean notTake = solve(arr, sum, idx + 1);
        boolean res = (take || notTake);
        if (res) memo[idx][sum] = 1;
        else memo[idx][sum] = 0;
        return res;
    }
}