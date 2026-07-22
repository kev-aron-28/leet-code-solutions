package daily;

import java.util.ArrayDeque;
import java.util.Queue;

public class IsGraphBipartite {
    public boolean solution(int graph[][]) {
        int colors[] = new int[graph.length];

        for(int i = 0; i < graph.length; i++) {
            if(colors[i] != 0) continue;

            Queue<Integer> queue = new ArrayDeque<>();

            colors[i] = 1;
            queue.offer(i);

            while (!queue.isEmpty()) { 
                int node = queue.poll();

                // VIsit every neighbour of the current node
                for(int neighbour : graph[node]) {  
                    if(colors[neighbour] == 0) {
                        colors[neighbour] = -colors[node];

                        queue.offer(neighbour);
                    } 
                    // Neighbour already has a color
                    else if (colors[neighbour] == colors[node]) {
                        return false;
                    }
                }
            }

        }

        return true;
    }
}
