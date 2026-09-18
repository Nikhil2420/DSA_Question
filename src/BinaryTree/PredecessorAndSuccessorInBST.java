package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PredecessorAndSuccessorInBST {

    List<Node> temp = new ArrayList<>();

    public ArrayList<Node> findPreSuc(Node root, int key) {
        solve(root);
        ArrayList<Node> ans = new ArrayList<Node>();
        Collections.sort(temp, (a, b) -> a.val - b.val);
        Node pred = null;
        Node succ = null;
        for (Node node : temp) {
            if (node.val < key) {
                pred = node;
            } else if (node.val > key) {
                succ = node;
                break;
            }
        }

        ans.add(pred);
        ans.add(succ);
        return ans;

    }

    public void solve(Node root) {
        if (root == null) return;
        temp.add(root);
        solve(root.left);
        solve(root.right);
    }
}