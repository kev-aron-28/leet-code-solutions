package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class ExclusiveTimeOfFunctions {
    public int[] solution(int n, List<String> logs) {
        int result[] = new int[n];
        
        int prev = 0;

        Deque<Integer> stack = new ArrayDeque<>();

        for(String log : logs) {
            String parts[] = log.split(":");
            int id = Integer.parseInt(parts[0]);
            String type = parts[1];
            int time = Integer.parseInt(parts[2]);

            if (type.equals("start")) {
                
                if (!stack.isEmpty()) {
                    result[stack.peek()] += time - prev;
                }

                stack.offer(id);
                prev = time;
            } else {
                result[stack.peek()] += time - prev + 1;
                stack.pop();
                prev = time + 1;
            }
        }

        return result;
    }
}
