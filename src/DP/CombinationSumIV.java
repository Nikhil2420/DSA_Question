package DP;

public class CombinationSumIV {

    int[][] memo;

    public int combinationSum4(int[] nums, int target) {
        memo = new int[nums.length][target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                memo[i][j] = -1;
            }
        }
        return solve(nums, target, 0);
    }

    public int solve(int nums[], int target, int idx) {
        if (target == 0) return 1;
        if (idx >= nums.length || target < 0) return 0;
        if (memo[idx][target] != -1) return memo[idx][target];
        /*
            nums = [1,2,3], target = 4
                (1, 1, 1, 1)
                (1, 1, 2)
                (1, 2, 1)
                (1, 3)
                (2, 1, 1)
                (2, 2)
                (3, 1)
         */

        /*
            when we take any element we have to start from 0 to check every combination like 2 than 1 ,1
            that's why 0
         */
        int take = solve(nums, target - nums[idx], 0);
        int notTake = solve(nums, target, idx + 1);
        return memo[idx][target] = (take + notTake);
    }
}