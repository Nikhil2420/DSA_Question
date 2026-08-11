package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    boolean visited[];
    List<List<Integer>> ans;

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        int n = nums.length;
        visited = new boolean[n];
        backTrack(nums, new ArrayList<>());
        return ans;
    }

    public void backTrack(int nums[], List<Integer> temp) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            temp.add(nums[i]);
            backTrack(nums, temp);
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}