package BinaryTree;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        int height = solve(root);
        return (height != -1);
    }

    public int solve(TreeNode root) {
        if (root == null) return 0;
        int lh = solve(root.left);
        int rh = solve(root.right);
        if (lh == -1 || rh == -1) return -1;
        if (Math.abs(rh - lh) > 1) return -1;
        return 1 + Math.max(lh, rh);
    }

}