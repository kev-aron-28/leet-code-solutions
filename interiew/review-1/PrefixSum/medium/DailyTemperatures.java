package review-1.PrefixSum.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {
    public int[] solution(int temperatures[]) {
        int result[] = new int[temperatures.length];

        Deque<Integer> stack = new ArrayDeque<>();

        for(int t = 0; t < temperatures.length; t++) {
            while (!stack.isEmpty() && temperatures[t] > temperatures[stack.peek()]) { 
                int index = stack.poll();
                result[index] = t - index;
            }

            stack.push(t);
        }

        return result;
    }
}
