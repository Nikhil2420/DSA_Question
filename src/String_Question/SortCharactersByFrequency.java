package String_Question;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> {
            if (a.count != b.count) return b.count - a.count;
            return a.ch - b.ch;
        });
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxHeap.add(new Pair(entry.getKey(), entry.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Pair p = maxHeap.remove();
            for (int i = 0; i < p.count; i++) {
                sb.append(p.ch);
            }
        }
        return sb.toString();
    }
}