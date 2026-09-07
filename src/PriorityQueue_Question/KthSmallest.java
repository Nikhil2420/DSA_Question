package PriorityQueue_Question;

import java.util.PriorityQueue;

public class KthSmallest {

    public int kthSmallest(int[] arr, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

        for (int elem : arr) minHeap.add(elem);

        while (!minHeap.isEmpty() && k-- > 1) {

            minHeap.remove();
        }
        return minHeap.remove();
    }
}
