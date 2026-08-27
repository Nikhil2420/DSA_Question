package Stack_Question;

import java.util.ArrayList;
import java.util.Stack;

public class NextSmallerElement {

    public static ArrayList<Integer> nextSmallerEle(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            ans.add(i, -1);
        }

        Stack<Integer> nextSmaller = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {

            while (!nextSmaller.isEmpty() && nextSmaller.peek() >= arr[i]) {
                nextSmaller.pop();
            }

            if (!nextSmaller.isEmpty()) {
                ans.set(i, nextSmaller.peek());
            }
            nextSmaller.push(arr[i]);
        }
        return ans;
    }
}
