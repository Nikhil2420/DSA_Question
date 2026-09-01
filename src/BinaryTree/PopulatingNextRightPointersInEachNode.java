package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {

    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Node front = queue.poll();
                if (size > 0) front.next = queue.peek();
                else front.next = null;

                if (front.left != null) queue.add(front.left);
                if (front.right != null) queue.add(front.right);
            }
        }
        return root;
    }
}
