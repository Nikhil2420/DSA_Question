package Design;

import java.util.Stack;

public class ImplementQueueUsingStack {


    // Initialize your data members
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    void enqueue(int x) {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack2.push(x);
        while (!stack1.isEmpty()) stack2.push(stack1.pop());
        // Implement enqueue operation
    }

    void dequeue() {
        stack2.pop();
        // Implement dequeue operation
    }

    int front() {
        if (!stack2.isEmpty()) return stack2.peek();
        return -1;
        // Implement front operation
    }

    int size() {
        return stack2.size();
        // Implement size operation
    }
}
