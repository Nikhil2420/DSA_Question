package DP;

import java.util.Arrays;

public class FrogJump {

    int[] memo;

    int minCost(int[] height) {
        memo = new int[height.length];
        Arrays.fill(memo, -1);
        return solve(height, 0);
    }

    int solve(int height[], int idx) {
        if (idx == height.length - 1) return 0;
        if (memo[idx] != -1) return memo[idx];
        int op1 = Integer.MAX_VALUE;
        if (idx + 1 < height.length) {
            op1 = Math.abs(height[idx + 1] - height[idx]) + solve(height, idx + 1);
        }

        int op2 = Integer.MAX_VALUE;
        if (idx + 2 < height.length) {
            op2 = Math.abs(height[idx + 2] - height[idx]) + solve(height, idx + 2);
        }
        return memo[idx] = Math.min(op1, op2);
    }
}