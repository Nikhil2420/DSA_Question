package Deque_Questions;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class KSizedSubarrayMaximum {

    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        int n = arr.length;
        while (j < n) {

            while (!queue.isEmpty() && arr[queue.peekLast()] <= arr[j]) {
                queue.pollLast();
            }

            if (!queue.isEmpty() && queue.peek() <= j - k) {
                queue.pollFirst();
            }
            queue.addLast(j);
            if (j - i + 1 == k) {
                ans.add(arr[queue.peekFirst()]);
                i++;
            }
            j++;
        }
        return ans;
    }
}