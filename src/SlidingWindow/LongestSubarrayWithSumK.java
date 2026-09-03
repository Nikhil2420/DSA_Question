package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK {

    public int longestSubarray(int[] arr, int k) {

        Map<Long, Integer> prefixSum = new HashMap<>();
        long sum = 0;
        int maxLen = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == k) {
                maxLen = i + 1;
            }

            if (prefixSum.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - prefixSum.get(sum - k));
            }

            if (!prefixSum.containsKey(sum)) {
                prefixSum.put(sum, i);
            }
        }
        return maxLen;
    }
}
