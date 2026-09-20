package PriorityQueue_Question;

import java.util.PriorityQueue;

public class HandOfStraights {

    public boolean isNStraightHand(int[] hand, int groupSize) {

        int n = hand.length;
        if (n % groupSize != 0) return false;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        for (int elem : hand) minHeap.add(elem);
        while (!minHeap.isEmpty()) {
            int elem = minHeap.remove();
            for (int i = 1; i < groupSize; i++) {
                if (!minHeap.remove(elem + i)) return false;
            }
        }
        return true;
    }
}