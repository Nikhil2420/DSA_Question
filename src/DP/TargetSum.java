package DP;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, 0, target, 0);
    }

    public int solve(int[] nums, int idx, int target, int sum) {
        if (idx >= nums.length) {
            if (sum == target) return 1;
            return 0;
        }
        int positive = solve(nums, idx + 1, target, sum + nums[idx]);
        int negative = solve(nums, idx + 1, target, sum - nums[idx]);
        return (positive + negative);
    }
}