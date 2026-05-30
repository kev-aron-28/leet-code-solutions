package common;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {
    public int[] solution(int temperatures[]) {
        int solution[] = new int[temperatures.length];

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) { 
                int prev = stack.poll();

                solution[prev] = i - prev;
            }

            stack.push(i);
        }

        return solution;
    }
}
