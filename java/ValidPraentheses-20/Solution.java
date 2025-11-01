import java.util.Stack;

public class Solution {

    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                stack.add(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }

                char popped = stack.pop();

                if(c == ')' && popped != '(') return false;
                if(c == '}' && popped != '{') return false;
                if(c == ']' && popped != '[') return false;
            }
        }
        
        if(!stack.isEmpty()) return false;

        return true;   
    }

    public static void main(String args[]) {

    }
}