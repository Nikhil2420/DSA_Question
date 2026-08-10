package DP;

public class JumpGame {

    Integer memo[];

    public boolean canJump(int[] nums) {
        memo = new Integer[nums.length];
        return solve(nums, 0);
    }

    public boolean solve(int nums[], int idx) {
        if (idx >= nums.length) return false;
        if (idx == nums.length - 1) return true;
        if (memo[idx] != null) {
            return (memo[idx] == 1);
        }
        for (int i = 1; i <= nums[idx]; i++) {
            boolean val = solve(nums, idx + i);
            if (val) {
                memo[idx] = 1;
                return val;
            } else {
                memo[idx] = 0;
            }

        }
        memo[idx] = 0;
        return false;
    }
}