package SlidingWindow;

public class MaximumPointsYouCanObtainFromCards {

    int[][] memo;

    public int maxScoreRecursiveSolution(int[] cardPoints, int k) {
        int n = cardPoints.length;
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        return solve(cardPoints, k, 0, n - 1);
    }

    public int solve(int[] cardPoints, int k, int i, int j) {
        if (k == 0 || i > j) {
            return 0;
        }
        if (memo[i][j] != -1) return memo[i][j];

        int takeStart = cardPoints[i] + solve(cardPoints, k - 1, i + 1, j);
        int takeLast = cardPoints[j] + solve(cardPoints, k - 1, i, j - 1);
        return memo[i][j] = Math.max(takeStart, takeLast);
    }


    public int maxScoreOptimalSlidingWindowSolution(int[] cardPoints, int k) {
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }
        int rightIndex = cardPoints.length - 1;
        int max = leftSum;
        for (int i = k - 1; i >= 0; i--) {
            rightSum += cardPoints[rightIndex];
            leftSum -= cardPoints[i];
            rightIndex--;
            max = Math.max(max, leftSum + rightSum);
        }
        return max;
    }
}