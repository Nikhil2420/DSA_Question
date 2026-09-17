package BinaryTree;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    public boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        /*
             if(left==null && right!=null)return false;
             if(right==null && left!=null)return false;
             below if condition equals this
         */
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return (check(left.left, right.right) && check(left.right, right.left));
    }
}