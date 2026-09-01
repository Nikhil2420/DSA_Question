package BinaryTree;

public class LowestCommonAncestorOfABinarySearchTree {

    public TreeNode lowestCommonAncestorBinarySearchTree(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestorBinarySearchTree(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestorBinarySearchTree(root.right, p, q);
        }
        return root;
    }
}
