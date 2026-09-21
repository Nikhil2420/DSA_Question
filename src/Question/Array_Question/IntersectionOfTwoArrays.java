package Question.Array_Question;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int elem : nums2) set.add(elem);
        int n = nums1.length;
        for (int elem : nums1) {
            if (set.contains(elem)) {
                ans.add(elem);
                set.remove(elem);
            }
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}