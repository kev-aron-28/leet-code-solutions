package common;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()) {
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;

                char pop = stack.poll();

                if(c == ')' && pop != '(') return false;
                if(c == '}' && pop != '{') return false;
                if(c == ']' && pop != '[') return false;
            }
        }

        return stack.isEmpty();
    }
}
