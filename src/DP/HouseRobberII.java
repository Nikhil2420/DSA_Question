package DP;

import java.util.Arrays;

public class HouseRobberII {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] memo1 = new int[n];
        int[] memo2 = new int[n];
        Arrays.fill(memo1, -1);
        Arrays.fill(memo2, -1);
        return Math.max(solve(0, n - 1, nums, memo1), solve(1, n, nums, memo2));
    }


    public int solve(int idx, int n, int nums[], int memo[]) {
        if (idx >= n) return 0;
        if (memo[idx] != -1) return memo[idx];
        int take = nums[idx] + solve(idx + 2, n, nums, memo);
        int notTake = solve(idx + 1, n, nums, memo);
        return memo[idx] = Math.max(take, notTake);
    }
}