package Question;

import java.util.Stack;

public class DecodeTheString {
    public static void main(String[] args) {
        String res = DecodeTheString.decodedString("3[b2[ca]]");
        System.out.println(res);
    }

    static String decodedString(String s) {
        // code here
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch != ']') {
                stack.push(ch);
            } else {
                String str = "";
                while (!stack.isEmpty() && !Character.isDigit(stack.peek())) {
                    char c = stack.pop();
                    if (c == '[') continue;
                    str = c + str;
                }
                String number = "";
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    number = stack.pop() + number;
                }
                int times = Integer.parseInt(number);

                String res = "";
                for (int j = 1; j <= times; j++) res += str;
                for (char c : res.toCharArray()) {
                    stack.push(c);
                }
            }
        }

        String ans = "";
        while (!stack.isEmpty()) ans = stack.pop() + ans;
        return ans;
    }

}