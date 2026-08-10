package GameStrategy;

public class StoneGame {
    int memo[][];

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        int alice = solve(0, n - 1, piles);
        int sum = 0;
        for (int elem : piles) {
            sum += elem;
        }
        int bob = sum - alice;
        return (alice > bob);
    }

    public int solve(int i, int j, int piles[]) {

        if (i > j) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        int takeStart = piles[i] + Math.min(solve(i + 2, j, piles), solve(i + 1, j - 1, piles));
        int takeEnd = piles[j] + Math.min(solve(i + 1, j - 1, piles), solve(i, j - 2, piles));
        memo[i][j] = Math.max(takeStart, takeEnd);
        return memo[i][j];
    }

}