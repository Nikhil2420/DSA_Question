package PriorityQueue_Question;

import java.util.PriorityQueue;

public class MinCostToConnectRopes {

    public int minCost(int[] arr) {

        int n = arr.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        for (int elem : arr) minHeap.add(elem);

        int totalCost = 0;
        while (minHeap.size() >= 2) {
            int first = minHeap.remove();
            int second = minHeap.remove();
            int cost = (first + second);
            totalCost += cost;
            minHeap.add(cost);
        }
        return totalCost;
    }
}