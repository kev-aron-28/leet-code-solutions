package review-1.HashMapSet.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {
    public int solution(char[] tasks, int n) {
        int count[] = new int[26];
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

        for(char t : tasks) {
            count[t - 'A']++;
        }

        for(int f : count) {
            if(f > 0) maxHeap.offer(f);
        }

        int time = 0;
        while (!maxHeap.isEmpty()) { 
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;


            while(cycle > 0 && !maxHeap.isEmpty()) {
                int freq = maxHeap.poll();

                if(freq > 1) {
                    temp.add(freq - 1);
                }

                time++;
                cycle--;
            }

            for(int freq : temp ) {
                maxHeap.offer(freq);
            }

            if (maxHeap.isEmpty()) {
               break; 
            }

            time += cycle;
        }

        return time;
    }
}
