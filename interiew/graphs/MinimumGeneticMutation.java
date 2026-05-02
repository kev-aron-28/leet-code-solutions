package graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation {
    public int solution(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));

        if(!bankSet.contains(endGene)) return -1;

        char genes[] = { 'A','C','G','T' };

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(startGene);

        Set<String> visited =  new HashSet<>();
        visited.add(startGene);

        int steps = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                String current = queue.poll();

                if(current.equals(endGene)) return steps;

                char arr[] = current.toCharArray();

                for(int c = 0; c < arr.length; c++) {
                    char original = arr[c];

                    for(char g : genes) {
                        if(g == original) continue;

                        arr[c] = g;

                        String next = new String(arr);

                        if(bankSet.contains(next) && !visited.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                    }

                    arr[c] = original;
                }
            }
            steps++;
        }

        return -1;
    }
}
