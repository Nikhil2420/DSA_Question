package PriorityQueue_Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentInArray {

    public ArrayList<Integer> topKFreq(int[] arr, int k) {

        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int elem : arr) map.put(elem, map.getOrDefault(elem, 0) + 1);
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> {
            if (a.count != b.count) return b.count - a.count;
            return b.elem - a.elem;
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(new Pair(entry.getKey(), entry.getValue()));
        }

        while (k-- > 0 && !maxHeap.isEmpty()) {
            ans.add(maxHeap.remove().elem);
        }
        return ans;
    }
}

