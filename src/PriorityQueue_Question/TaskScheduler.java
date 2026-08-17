package PriorityQueue_Question;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {

    public int leastInterval(int k, ArrayList<Character> tasks) {
        // code here
        int ch[] = new int[26];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < tasks.size(); i++) {
            ch[tasks.get(i) - 'A']++;
        }

        for (int i = 0; i < 26; i++) {
            if (ch[i] > 0) maxHeap.add(ch[i]);
        }

        int time = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i <= k; i++) {
                //after doing one task that same task can be done after k period
                //so in between we do other task
                //that's why a total k+1 task
                if (!maxHeap.isEmpty()) {
                    int cnt = maxHeap.poll();
                    cnt--;
                    if (cnt > 0) temp.add(cnt);
                    time++;
                } else {
                    if (temp.size() == 0) break;
                    time++;
                }
            }
            for (int elem : temp) maxHeap.add(elem);
        }
        return time;
    }
}