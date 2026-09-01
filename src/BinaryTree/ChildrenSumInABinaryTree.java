package BinaryTree;

import DP.Node;

public class ChildrenSumInABinaryTree {

    public boolean isSumProperty(Node root) {
        if (root == null) return true;

        if (root.left != null && root.right != null) {
            if (root.left.data + root.right.data != root.data) return false;
        }

        if (root.left != null && root.right == null) {
            if (root.left.data != root.data) return false;
        }

        if (root.left == null && root.right != null) {
            if (root.right.data != root.data) return false;
        }

        boolean left = isSumProperty(root.left);
        boolean right = isSumProperty(root.right);
        return (left && right);
    }
}
