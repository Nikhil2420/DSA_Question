package Question.Array_Question;

import java.util.Arrays;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        int ans = 0;

        /*
                [1, 100]
                [2, 3]
                [3, 4]
                that's why we are sorting by end time
                if we do it by start time ans=2
                but if do it with end time
                the ans will be 1
                [2,3] [3,4] [1,100]
         */
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
            } else {
                ans++;
            }
        }
        return ans;
    }
}
