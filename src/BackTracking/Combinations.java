package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Combinations {

    Set<List<Integer>> ans = new HashSet<>();
    int nums[];

    public List<List<Integer>> combine(int n, int k) {
        nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = i + 1;
        sum(k, new ArrayList<>(), 0, n);
        return new ArrayList<>(ans);
    }

    public void sum(int k, List<Integer> temp, int idx, int n) {
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = idx; i < n; i++) {
            temp.add(nums[i]);
            sum(k, temp, i + 1, n);
            temp.removeLast();
        }
    }
}
