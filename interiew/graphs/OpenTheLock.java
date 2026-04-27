package graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock {
    publict int solution(String[] deadEnds, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadEnds));

        if(dead.contains("0000")) return -1;

        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.offer("0000");
        visited.add("0000");


        int steps = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                String curr = queue.poll();

                if(curr.equals(target)) return steps;

                for(String next : getNei(curr)) {
                    if(!dead.contains(next) && !visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    private List<String> getNei(String current) {
        List<String> result = new ArrayList<>();



        for(int i = 0; i < 4; i++) {
            char arr[] = current.toCharArray();

            arr[i] = (char)((arr[i] - '0' + 1) % 10 + '0');

            result.add(new String(arr));

        }

        return result; 
    }
}
