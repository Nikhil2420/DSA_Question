package Stack_Question;

import java.util.Stack;

public class OnlineStockSpan {


    Stack<Pair> stack;

    public OnlineStockSpan() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek().price <= price) {
            span += stack.pop().span;
        }
        stack.push(new Pair(price, span));
        return span;
    }
}
