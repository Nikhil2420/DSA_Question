package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTreeLeetcode {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node == null) {
                sb.append("-10001");
                sb.append(",");
                continue;
            }
            sb.append(node.val);
            sb.append(",");
            queue.add(node.left);
            queue.add(node.right);

        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.startsWith("-10001")) return null;
        String[] res = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(res[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < res.length) {
            TreeNode node = queue.remove();
            int left = Integer.parseInt(res[i]);
            if (left != -10001) {
                node.left = new TreeNode(left);
                queue.add(node.left);
            }
            i++;
            int right = Integer.parseInt(res[i]);
            if (right != -10001) {
                node.right = new TreeNode(right);
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}
