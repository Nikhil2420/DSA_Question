package DP;



public class CoinChange2 {

    int memo[][];

    public int change(int amount, int[] coins) {
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
                return 1;
            }
            return 0;
        }
        if (memo[i][amount] != -1) return memo[i][amount];
        int take = 0;
        if (coins[i] <= amount) {
            take = solve(coins, amount - coins[i], i);
        }
        int notTake = solve(coins, amount, i - 1);
        memo[i][amount] = take + notTake;
        return memo[i][amount];
    }
}