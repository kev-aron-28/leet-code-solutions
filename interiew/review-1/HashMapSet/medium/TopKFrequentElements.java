package review-1.HashMapSet.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] solution(int nums[], int k) {
        Map<Integer, Integer> count = new HashMap<>();

        for(int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> count.get(a) - count.get(b));

        for(int num : count.keySet()) {
            minHeap.offer(num);

            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int result[] = new int[k];

        for(int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}
