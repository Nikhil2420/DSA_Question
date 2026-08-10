package Design;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {


    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public ImplementStackUsingQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
        queue2.add(x);
        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }
    }

    public int pop() {
        return queue2.poll();
    }

    public int top() {
        return queue2.peek();
    }

    public boolean empty() {
        return queue2.isEmpty();
    }
}

