package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {
    public int[] solution(int temperatures[]) {
        int n = temperatures.length;
        int result[] = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            int currentTemperature = temperatures[i];

            while(!stack.isEmpty() && temperatures[stack.peek()] < currentTemperature) {
                int index = stack.pop();

                result[index] = i - index;
            }

            stack.push(i);
        }

        return result;
    }
}
