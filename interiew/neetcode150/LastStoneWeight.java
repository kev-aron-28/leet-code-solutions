package neetcode150;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int solution (int stones[]) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int s : stones) {
            queue.add(s);
        }

        while(queue.size() > 1) {
            int first = queue.poll();
            int second = queue.poll();

            if(first != second) {
                queue.offer(first - second);
            }
        }

        return queue.isEmpty() ? 0 : queue.peek();
    }
}
