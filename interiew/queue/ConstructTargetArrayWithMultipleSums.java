package queue;

import java.util.PriorityQueue;

public class ConstructTargetArrayWithMultipleSums {
    public boolean solution(int target[]) {
        PriorityQueue<Long> maxHeap = new PriorityQueue<>((a,b) -> Long.compare(b, a));

        long sum = 0;

        for(int n : target) {
            maxHeap.offer((long) n);

            sum += n;
        }

        while (true) { 
            long largest = maxHeap.poll();
            long rest = sum - largest;

            if(largest == 1 || rest == 1) {
                return true;
            }

            if (rest == 0 || largest <= rest) {
                return false;
            }

            long previous = largest % rest;

            if(previous == 0) {
                return false;
            }

            maxHeap.offer(previous);

            sum = rest + previous;
        }
    }
}
