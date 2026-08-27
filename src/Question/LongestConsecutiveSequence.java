package Question;

import java.util.Arrays;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int last = nums[0];
        int cnt = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (last == nums[i] - 1) {
                cnt++;
                last = nums[i];
            }

            //[0,1,1,2]
            //for these cases we don't write else directly
            else if (nums[i] != last) {
                last = nums[i];
                cnt = 1;
            }
            max = Math.max(cnt, max);
        }
        return max;
    }
}