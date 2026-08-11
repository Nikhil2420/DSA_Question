package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    List<List<Integer>> ans;

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        solve(nums, 0, new ArrayList<>());
        return ans;
    }

    public void solve(int nums[], int idx, List<Integer> temp) {
        if (idx >= nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        solve(nums, idx + 1, temp);
        temp.remove(temp.size() - 1);
        solve(nums, idx + 1, temp);
    }

}