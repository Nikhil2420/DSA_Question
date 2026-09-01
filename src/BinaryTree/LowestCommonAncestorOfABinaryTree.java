package BinaryTree;

public class LowestCommonAncestorOfABinaryTree {

    public TreeNode lowestCommonAncestorBinaryTree(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestorBinaryTree(root.left, p, q);
        TreeNode right = lowestCommonAncestorBinaryTree(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}

