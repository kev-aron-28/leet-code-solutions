package daily;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler-29-09-2026 {
    public int solution(char tasks[], int n) {
        int freq[] = new int[26];
        
        for(char c : tasks) {
            freq[c - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

        for(int f : freq) {
            if(f > 0) maxHeap.offer(f);
        }

        int time = 0;

        while(!maxHeap.isEmpty()) {
            int take = n + 1;

            List<Integer> remain = new ArrayList<>();
            while (take > 0 && !maxHeap.isEmpty()) { 
                int poll = maxHeap.poll();
                
                if(poll > 1) {
                    remain.add(poll - 1);
                }

                time++;
                take--;
            }

            for(int f : remain) {
                maxHeap.offer(f);
            }

            if(maxHeap.isEmpty()) break;

            time += take;
        } 

        return time;
    }
}
