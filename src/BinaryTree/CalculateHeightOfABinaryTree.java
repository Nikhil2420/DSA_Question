package BinaryTree;

public class CalculateHeightOfABinaryTree {

    public int calculateHeightOfABinaryTree(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = calculateHeightOfABinaryTree(root.left);
        int rightHeight = calculateHeightOfABinaryTree(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
