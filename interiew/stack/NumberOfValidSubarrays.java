package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberOfValidSubarrays {
    public int solution(int nums[]) {
        int result = 0;
        
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) { 
                stack.pop();
            }

            if (stack.isEmpty()) {
               result += nums.length - i; 
            } else {
                result += stack.peek() - i;
            }

            stack.push(i);
        }

        return result;
    }
}
