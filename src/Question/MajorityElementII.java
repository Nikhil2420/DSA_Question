package Question;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {

        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;
        int elem1 = 0;
        int elem2 = 0;
        for (int elem : nums) {
            if (count1 == 0 && elem != elem2) {
                count1++;
                elem1 = elem;
            } else if (count2 == 0 && elem != elem1) {
                count2++;
                elem2 = elem;
            } else if (elem == elem1) count1++;
            else if (elem == elem2) count2++;
            else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int elem : nums) {
            if (elem == elem1) count1++;
            else if (elem == elem2) count2++;
        }

        if (count1 > n / 3) ans.add(elem1);
        if (count2 > n / 3) ans.add(elem2);
        return ans;
    }
}