package DP;

import java.util.Arrays;

public class JumpGame2 {

    int memo[];

    public int jump(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return solve(nums, 0);
    }

    public int solve(int nums[], int idx) {
        if (idx >= nums.length) return (int) 1e9;
        if (idx == nums.length - 1) return 0;
        if (memo[idx] != -1) return memo[idx];
        int take = (int) 1e9;
        for (int i = 1; i <= nums[idx]; i++) {
            int ans = 1 + solve(nums, idx + i);
            take = Math.min(ans, take);
        }
        memo[idx] = take;
        return take;
    }
}