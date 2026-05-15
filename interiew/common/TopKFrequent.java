package common;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    public int[] solution(int nums[], int k) {
        Map<Integer, Integer> count = new HashMap<>();

        for(int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> count.get(a) - count.get(b));

        for(int num : count.keySet()) {
            heap.offer(num);

            if (heap.size() > k) {
                heap.poll();
            }
        }

        int topK[] = new int[k];

        for(int i = k - 1; i >= 0; i--) {
            topK[i] = heap.poll();
        }

        return topK;
    }
}
