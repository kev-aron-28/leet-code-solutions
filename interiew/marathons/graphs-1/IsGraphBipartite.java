package marathons.graphs-1;

import java.util.ArrayDeque;
import java.util.Queue;

public class IsGraphBipartite {
    public boolean solution(int graph[][]) {
        int colors[] = new int[graph.length];

        for(int node = 0; node < graph.length; node++) {
            if (colors[node] != 0) continue;

            Queue<Integer> queue = new ArrayDeque<>();

            colors[node] = 1;

            queue.add(node);

            while (!queue.isEmpty()) { 
                int currentNode = queue.poll();

                for(int neighbour : graph[currentNode]) {
                    if (colors[neighbour] == 0) {
                        colors[neighbour] = -colors[currentNode];

                        queue.offer(neighbour);
                    } else if(colors[neighbour] == colors[currentNode]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
