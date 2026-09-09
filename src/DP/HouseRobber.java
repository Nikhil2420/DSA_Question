package DP;

import java.util.Arrays;

public class HouseRobber {

    int[] memo;

    public int rob(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        return solve(nums, n - 1);
    }

    public int solve(int[] nums, int idx) {
        if (idx < 0) return 0;
        if (memo[idx] != -1) return memo[idx];
        int take = nums[idx] + solve(nums, idx - 2);
        int notTake = solve(nums, idx - 1);
        return memo[idx] = Math.max(take, notTake);
    }
}