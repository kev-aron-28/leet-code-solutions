package queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementQueueUsingStacks {

    private final Deque<Integer> stack1 = new ArrayDeque<>();
    private final Deque<Integer> stack2 = new ArrayDeque<>();

    public ImplementQueueUsingStacks() {
    }
    

    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        while (!stack1.isEmpty()) { 
            stack2.push(stack1.pop());
        }

        int r = stack2.pop();

        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return r;
    }
    
    public int peek() {
        while (!stack1.isEmpty()) { 
            stack2.push(stack1.pop());
        }

        int r = stack2.peek();

        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return r;
    }
    
    public boolean empty() {
        return stack1.isEmpty();
    }
}
