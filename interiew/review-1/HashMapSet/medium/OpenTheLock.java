package review

-1.HashMapSet.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock {

    public int solution(String deadEnds[], String target) {
        Set<String> ends = new HashSet<>();

        for (String dead : deadEnds) {
            ends.add(dead);
        }

        if (ends.contains("0000")) {
            return -1;
        }

        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.offer("0000");
        visited.add("0000");

        int steps = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String current = queue.poll();

                if (current.equals(target)) {
                    return steps;
                }

                for (String next : next(current)) {

                    if (ends.contains(next)
                            || visited.contains(next)) {
                        continue;
                    }

                    visited.add(next);
                    queue.offer(next);
                }
            }

            steps++;
        }

        return -1;
    }

    public List<String> next(String s) {
        List<String> neigh = new ArrayList<>();

        char sChar[] = s.toCharArray();

        for (int i = 0; i < sChar.length; i++) {
            char original = sChar[i];

            sChar[i] = original == '9' ? '0' : (char) (original + 1);

            neigh.add(new String(sChar));

            sChar[i] = original == '0' ? '9' : (char) (original - 1);

            neigh.add(new String(sChar));

            sChar[i] = original;
        }

        return neigh;
    }
}
