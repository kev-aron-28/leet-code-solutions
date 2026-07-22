package daily;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {
    public int[] solution(int temperatures[]) {
        int result[] = new int[temperatures.length];

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.poll();
                result[idx] = i - idx;
            }

            stack.push(i);
        }

        return result;
    } 
}
