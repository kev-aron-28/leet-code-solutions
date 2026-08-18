package marathons.graphs-1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;


public class MinimumGeneticMutation {
    public int solution(String startGene, String endGene, String[] bank) {
        Set<String> valid = new HashSet<>();

        valid.addAll(Arrays.asList(bank));

        if(!valid.contains(startGene) || !valid.contains(endGene)) return -1;

        Queue<String> queue = new ArrayDeque<>();

        Set<String> seen = new HashSet<>();

        queue.add(startGene);
        seen.add(startGene);

        int steps = 0;

        char list[] = new char[] { 'A', 'C', 'G', 'T' };

        while(!queue.isEmpty()) {
            int level = queue.size();

            for(int i = 0; i < level; i++) {
                String current = queue.poll();

                if(current.equals(endGene)) return steps;

                char chars[] = current.toCharArray();

                for(int j = 0; j < chars.length; j++) {
                    char original = chars[j];

                    for(char c : list) {
                        if(c == original) continue;
                        chars[j] = c;

                        String next = new String(chars);

                        if(valid.contains(next) && !seen.contains(next)) {
                            seen.add(next);
                            queue.add(next);
                        }
                    }

                    chars[j] = original;
                }
            }
            steps++;
        }

        return -1;
    }
}
