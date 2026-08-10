package DP;

public class CoinChange {
    int memo[][];

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        memo = new int[n][amount + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                memo[i][j] = -1;
            }
        }
        int value = solve(coins, amount, coins.length - 1);
        return value == (int) 1e9 ? -1 : value;
    }

    public int solve(int coins[], int amount, int i) {
        if (i == 0) {
            if (amount % coins[i] == 0) {
                return amount / coins[i];
            }
            return (int) 1e9;
        }
        if (memo[i][amount] != -1) return memo[i][amount];
        int take = Integer.MAX_VALUE;
        if (coins[i] <= amount) {
            take = 1 + solve(coins, amount - coins[i], i);
        }
        int notTake = solve(coins, amount, i - 1);
        memo[i][amount] = Math.min(take, notTake);
        return memo[i][amount];
    }
}