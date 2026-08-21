package Stack_Question;

import java.util.Stack;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int ans[] = new int[n];
        Stack<Temp> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek().temparature <= temperatures[i]) stack.pop();
            if (!stack.isEmpty()) {
                ans[i] = stack.peek().idx - i;
            } else {
                ans[i] = 0;
            }
            stack.push(new Temp(temperatures[i], i));
        }
        return ans;
    }
}
