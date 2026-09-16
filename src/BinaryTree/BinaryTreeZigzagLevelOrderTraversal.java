package BinaryTree;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int flag = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queue.remove();
                temp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            if (flag == 0) {
                ans.add(temp);
                flag = 1;
            } else {
                Collections.reverse(temp);
                ans.add(temp);
                flag = 0;
            }
        }
        return ans;
    }
}