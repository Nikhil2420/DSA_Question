package Question.interval_Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] ans = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            ans[i] = intervals[i];
        }
        ans[n] = newInterval;
        Arrays.sort(ans, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        int start = ans[0][0];
        int end = ans[0][1];
        for (int i = 1; i <= n; i++) {
            if (ans[i][0] <= end) {
                end = Math.max(end, ans[i][1]);
            } else {
                list.add(new int[]{start, end});
                start = ans[i][0];
                end = ans[i][1];
            }
        }

        list.add(new int[]{start, end});
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}