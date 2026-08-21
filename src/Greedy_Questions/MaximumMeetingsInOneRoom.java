package Greedy_Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaximumMeetingsInOneRoom {

    public ArrayList<Integer> maxMeetings(int[] s, int[] f) {

        ArrayList<Integer> ans = new ArrayList<>();
        MeetingRoom meeting[] = new MeetingRoom[s.length];
        for (int i = 0; i < s.length; i++) {
            meeting[i] = new MeetingRoom(s[i], f[i], i + 1);
        }
        Arrays.sort(meeting, (a, b) -> {
            if (a.end != b.end) return a.end - b.end;
            return a.pos - b.pos;
        });


        int en = meeting[0].end;
        ans.add(meeting[0].pos);
        for (int i = 1; i < s.length; i++) {
            if (meeting[i].start > en) {
                ans.add(meeting[i].pos);
                en = meeting[i].end;
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
