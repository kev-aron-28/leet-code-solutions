package common;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotation {
    public int solution(String [] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.poll() + stack.poll());
                    break;
                case "-":
                    int a = stack.poll();
                    int b = stack.poll();
                    stack.push(b - a);
                    break;
                case "*":
                    stack.push(stack.poll() * stack.poll());
                    break;
                case "/":
                    int x = stack.poll();
                    int y = stack.poll();
                    stack.push(y / x);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }

        return stack.poll();
    }
}
