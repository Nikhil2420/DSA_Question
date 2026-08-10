package GameStrategy;

public class PredictTheWinner {
    public boolean predictTheWinner(int[] nums) {
        int sum = 0;
        for (int elem : nums) sum += elem;
        if (sum == 0) return true;
        int alice = solve(nums, 0, nums.length - 1);
        int bob = sum - alice;
        return alice >= bob ? true : false;
    }

    public int solve(int nums[], int i, int j) {
        if (i > j) return 0;
        int takeFirst = nums[i] + Math.min(solve(nums, i + 2, j), solve(nums, i + 1, j - 1));
        int takeEnd = nums[j] + Math.min(solve(nums, i, j - 2), solve(nums, i + 1, j - 1));
        return Math.max(takeFirst, takeEnd);
    }
}
