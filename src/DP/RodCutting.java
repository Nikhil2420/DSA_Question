package DP;

public class RodCutting {

    int[][] memo;

    public int cutRod(int[] price) {

        int n = price.length;
        memo = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                memo[i][j] = -1;
            }
        }
        return solve(n - 1, n, price);
    }

    public int solve(int idx, int n, int price[]) {
        if (idx == 0) {
            return n * price[0];
        }
        if (memo[idx][n] != -1) return memo[idx][n];
        int take = Integer.MIN_VALUE;
        int rodLength = idx + 1;
        if (rodLength <= n) {
            take = price[idx] + solve(idx, n - rodLength, price);
        }
        int notTake = solve(idx - 1, n, price);
        return memo[idx][n] = Math.max(take, notTake);
    }
}