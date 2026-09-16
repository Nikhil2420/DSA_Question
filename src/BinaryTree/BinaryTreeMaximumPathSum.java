package BinaryTree;

public class BinaryTreeMaximumPathSum {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        solve(root);
        return maxSum;
    }

    public int solve(TreeNode root) {
        if (root == null) return 0;
        int left = solve(root.left);
        int right = solve(root.right);
        int nichaMilgya = left + right + root.val;
        int leftYaRightSaKoiEkAccha = Math.max(left, right) + root.val;
        int rootHiAccha = root.val;
        maxSum = Math.max(maxSum, Math.max(nichaMilgya, Math.max(leftYaRightSaKoiEkAccha, rootHiAccha)));
        return Math.max(leftYaRightSaKoiEkAccha, rootHiAccha);
    }
}