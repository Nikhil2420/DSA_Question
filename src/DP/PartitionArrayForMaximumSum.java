package DP;

import java.util.Arrays;

public class PartitionArrayForMaximumSum {

    int[] memo;

    public int maxSumAfterPartitioning(int[] arr, int k) {
        memo = new int[arr.length];
        Arrays.fill(memo, -1);
        return solve(0, arr, k);
    }

    public int solve(int idx, int arr[], int k) {

        if (idx >= arr.length) return 0;
        if (memo[idx] != -1) return memo[idx];
        int result = 0;
        int currMax = -1;
        for (int i = idx; i < arr.length && i - idx + 1 <= k; i++) {
            currMax = Math.max(currMax, arr[i]);
            result = Math.max(result, (currMax * (i - idx + 1)) + solve(i + 1, arr, k));
        }
        return memo[idx] = result;
    }
}