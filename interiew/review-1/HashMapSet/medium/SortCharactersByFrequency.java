package review-1.HashMapSet.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    public String solution(String s) {
        Map<Character, Integer> count = new HashMap<>();

        for(char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> count.get(b) - count.get(a));

        maxHeap.addAll(count.keySet());

        StringBuilder result = new StringBuilder();

        while(!maxHeap.isEmpty()) {
            char c = maxHeap.poll();

            for(int i = 0; i < count.get(c); i++) {
                result.append(c);
            }
        }


        return result.toString();
    } 
}
