package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SubsetsII {

    HashSet<List<Integer>> ans = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        sub(nums, 0, new ArrayList<>());
        return new ArrayList<>(ans);
    }

    public void sub(int nums[], int idx, List<Integer> temp) {
        if (idx >= nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        sub(nums, idx + 1, temp);//take
        temp.remove(temp.size() - 1);
        sub(nums, idx + 1, temp);//nottake
    }
}