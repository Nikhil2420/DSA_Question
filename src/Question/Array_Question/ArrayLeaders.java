package Question.Array_Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class ArrayLeaders {

    public static ArrayList<Integer> leaders(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            int elem = arr[i];
            if (stack.isEmpty() || elem >= stack.peek()) {
                stack.push(elem);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while (!stack.isEmpty()) ans.add(stack.pop());

        return ans;

    }

    public static ArrayList<Integer> leadersOptimal(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int max = arr[n - 1];
        ans.add(max);
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= max) {
                max = arr[i];
                ans.add(max);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
