package DP;

public class MaximumPathSum {

    int max = Integer.MIN_VALUE;

    public int findMaxSum(Node root) {
        solve(root);
        return max;
    }

    public int solve(Node root) {
        if (root == null) return 0;
        int left = solve(root.left);
        int right = solve(root.right);

        //aigaa bej nhi sakte isko as path left root right
        int milgya_answer = left + right + root.data;
        int koi_ek_accha = Math.max(left, right) + root.data;
        int root_accha = root.data;
        max = Math.max(max, Math.max(milgya_answer, Math.max(koi_ek_accha, root_accha)));
        return Math.max(koi_ek_accha, root_accha);

    }
}