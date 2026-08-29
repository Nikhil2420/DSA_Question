package DP;

public class KnapsackProblem {


    int memo[][];

    public int knapsack(int W, int val[], int wt[]) {
        memo = new int[val.length][W + 1];
        for (int i = 0; i < val.length; i++) {
            for (int j = 0; j <= W; j++) {
                memo[i][j] = -1;
            }
        }

        return memoization(W, val, wt, 0);

    }


    public int memoization(int capacity, int val[], int wt[], int idx) {
        if (idx >= val.length) return 0;
        if (memo[idx][capacity] != -1) return memo[idx][capacity];
        int take = 0;
        if (capacity >= wt[idx]) {
            take = val[idx] + memoization(capacity - wt[idx], val, wt, idx + 1);
        }
        int notTake = memoization(capacity, val, wt, idx + 1);
        memo[idx][capacity] = Math.max(take, notTake);
        return memo[idx][capacity];
    }
}
