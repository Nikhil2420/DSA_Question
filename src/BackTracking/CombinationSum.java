package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        solve(candidates, target, 0, new ArrayList<>());
        return ans;
    }

    public void solve(int arr[], int tar, int idx, List<Integer> temp) {
        if (tar == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if (idx >= arr.length || tar < 0) return;

        temp.add(arr[idx]);
        solve(arr, tar - arr[idx], idx, temp);
        temp.remove(temp.size() - 1);
        solve(arr, tar, idx + 1, temp);
    }
}