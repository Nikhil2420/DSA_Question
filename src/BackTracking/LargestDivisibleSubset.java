package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        solve(nums, 0, -1, new ArrayList<>());
        return ans;
    }

    public void solve(int[] nums, int currIdx, int prevIdx, List<Integer> temp) {

        if (temp.size() > ans.size()) {
            ans = new ArrayList<>(temp);
        }

        if (currIdx >= nums.length) {
            return;
        }


        //take
        if (prevIdx == -1 || (nums[currIdx] % nums[prevIdx] == 0)) {
            temp.add(nums[currIdx]);
            solve(nums, currIdx + 1, currIdx, temp);
            temp.removeLast();
        }

        //notTake
        solve(nums, currIdx + 1, prevIdx, temp);
    }
}