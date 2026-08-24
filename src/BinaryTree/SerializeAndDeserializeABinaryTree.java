package BinaryTree;

import DP.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeABinaryTree {

    public ArrayList<Integer> serialize(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            Node node = queue.remove();
            if (node == null) {
                ans.add(-1);
                continue;
            }
            ans.add(node.data);
            queue.add(node.left);
            queue.add(node.right);
        }

        return ans;

    }

    public Node deSerialize(ArrayList<Integer> arr) {
        if (arr.get(0) == -1) return null;
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(arr.get(0));
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {

            Node node = queue.remove();

            if (arr.get(i) != -1) {
                node.left = new Node(arr.get(i));
                queue.add(node.left);
            }
            i++;
            if (arr.get(i) != -1) {
                node.right = new Node(arr.get(i));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

};