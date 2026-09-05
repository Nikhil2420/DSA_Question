package BFS;

import BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        int maxLen = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int lc = 0;
            int rc = 0;
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                TreeNode node = pair.node;
                if (i == 0) {
                    lc = pair.idx;
                }

                if (i == size - 1) {
                    rc = pair.idx;
                }
                if (node.left != null) {
                    queue.add(new Pair(node.left, 2 * pair.idx + 1));
                }
                if (node.right != null) {
                    queue.add(new Pair(node.right, 2 * pair.idx + 2));
                }
            }
            maxLen = Math.max(maxLen, rc - lc + 1);
        }
        return maxLen;

    }
}
