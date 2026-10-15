package queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class TimeNeededToBuyTickets {
    
    public int solution(int tickets[], int k) {
        Deque<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i < tickets.length; i++) {
            queue.offer(i);
        }

        int time = 0;

        while (!queue.isEmpty()) { 
            int person = queue.poll();

            tickets[person]--;
            time++;

            if (tickets[person] == 0 && person == k) {
                return time;
            }

            if (tickets[person] > 0) {
                queue.offer(person);
            }
        }

        return time;
    }
}
