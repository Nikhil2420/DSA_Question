package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, target, 0, new ArrayList<>());
        return ans;
    }

    public void solve(int arr[], int tar, int idx, List<Integer> temp) {
        if (tar == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            if (i != idx && arr[i] == arr[i - 1]) continue;
            if (arr[i] > tar) break;
            temp.add(arr[i]);
            solve(arr, tar - arr[i], i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}