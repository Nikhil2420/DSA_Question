package Stack_Question;

import java.util.Stack;

public class SumOfSubarrayMinimums {

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = (int) Math.pow(10, 9) + 7;
        /*
            NSE->Next Smaller Element like for index 1 after index 1
            PSE->Previous Smaller Element like for index 2 before index 2
        */
        int[] NSE = getNSE(arr, n);
        int[] PSE = getPSE(arr, n);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long count = (long) (i - PSE[i]) * (NSE[i] - i);
            sum = (sum + (count * arr[i]) % mod) % mod;
        }
        return (int) sum;
    }

    public int[] getNSE(int[] arr, int n) {//right side
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return result;
    }

    public int[] getPSE(int[] arr, int n) {//left side
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return result;
    }
}
