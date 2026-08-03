package daily;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    public String solution(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> max = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));

        max.addAll(map.keySet());

        StringBuilder result = new StringBuilder();

        while (!result.isEmpty()) { 
            char c = max.poll();

            for(int i = 0; i < map.get(c); i++) {
                result.append(c);
            }
        }

        return result.toString();
    }
}
 