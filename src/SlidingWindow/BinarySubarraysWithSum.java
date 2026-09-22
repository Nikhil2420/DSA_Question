package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum {

    public int numSubarraysWithSum(int[] nums, int goal) {

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        map.put(0, 1);
        for (int elem : nums) {
            sum += elem;
            if (map.containsKey(sum - goal)) count += map.get(sum - goal);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}