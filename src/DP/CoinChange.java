package DP;

public class CoinChange {

    int memo[][];

    public int coinChange(int[] coins, int amount) {
        memo = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                memo[i][j] = -1;
            }
        }
        int res = solve(coins, amount, 0);
        return res == (int) 1e9 ? -1 : res;
    }

    public int solve(int coins[], int amount, int idx) {
        if (idx >= coins.length || amount < 0) return (int) 1e9;
        if (amount == 0) return 0;
        if (memo[idx][amount] != -1) return memo[idx][amount];
        int take = 1 + solve(coins, amount - coins[idx], idx);
        int notTake = solve(coins, amount, idx + 1);
        memo[idx][amount] = Math.min(take, notTake);
        return memo[idx][amount];
    }
}