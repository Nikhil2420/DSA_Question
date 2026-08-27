package PriorityQueue_Question;

import java.util.*;

public class MaximumSumCombination {

    public ArrayList<Integer> topKSumTrios(int[] a, int[] b, int k) {

        Arrays.sort(a);
        Arrays.sort(b);
        int n = a.length;
        ArrayList<Integer> ans = new ArrayList<>();

        PriorityQueue<Trio> maxHeap = new PriorityQueue<>((c, d) -> d.sum - c.sum);
        maxHeap.add(new Trio(n - 1, n - 1, a[n - 1] + b[n - 1]));
        Set<String> visited = new HashSet<>();
        visited.add((n - 1) + "" + (n - 1));
        while (!maxHeap.isEmpty() && k-- > 0) {
            Trio p = maxHeap.remove();
            ans.add(p.sum);

            int i = p.i;
            int j = p.j;
            String key1 = (i - 1) + "#" + j;
            String key2 = i + "#" + (j - 1);
            if (i - 1 >= 0) {
                if (!visited.contains(key1)) {
                    visited.add(key1);
                    maxHeap.add(new Trio(i - 1, j, a[i - 1] + b[j]));
                }
            }

            if (j - 1 >= 0) {
                if (!visited.contains(key2)) {
                    visited.add(key2);
                    maxHeap.add(new Trio(i, j - 1, a[i] + b[j - 1]));
                }
            }
        }
        return ans;

    }
}

