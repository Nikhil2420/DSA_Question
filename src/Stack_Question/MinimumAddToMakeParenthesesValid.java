package Stack_Question;

import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {

    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
                else stack.push(s.charAt(i));
            }
        }
        return stack.size();
    }
}