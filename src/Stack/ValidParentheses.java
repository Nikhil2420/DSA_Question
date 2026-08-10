package Stack;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                char find = '/';
                if (ch == ')') find = '(';
                else if (ch == '}') find = '{';
                else find = '[';
                if (stack.isEmpty() || stack.pop() != find) return false;
            }
        }
        return stack.isEmpty();
    }
}