package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers {

    public int subarraysWithKDistinct(int[] nums, int k) {

        /*
            let's say we have k=3
            then first we are calculation all subarray with at most k{0,1,2,3}
            then at most k-1 {0,1,2}
            after subtracting we get subarray for only k that is this case {3}

            formula j-i+1 provide all subarray ending with 'j'
         */
        return (atMostKDistinctNumber(nums, k) - atMostKDistinctNumber(nums, k - 1));
    }

    public int atMostKDistinctNumber(int nums[], int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int count = 0;
        while (j < nums.length) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while (map.size() > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }
            count += j - i + 1;
            j++;
        }
        return count;

    }
}