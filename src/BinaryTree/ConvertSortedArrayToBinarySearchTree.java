package BinaryTree;

public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return solve(0, nums.length - 1, nums);
    }

    public TreeNode solve(int low, int high, int nums[]) {
        if (low > high) return null;
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = solve(low, mid - 1, nums);
        node.right = solve(mid + 1, high, nums);
        return node;
    }
}