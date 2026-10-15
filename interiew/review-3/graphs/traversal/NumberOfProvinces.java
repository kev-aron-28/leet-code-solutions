package review
-3.graphs.traversal;

import java.util.ArrayDeque;
import java.util.*:

public class NumberOfProvinces {
    public int solution(int isConnected[][]) {
        int n = isConnected.length;
        int provinces = 0;

        boolean visited[] = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;

            provinces++;

            queue.offer(i);

            visited[i] = true;

            while(!queue.isEmpty()) {
                int city  = queue.poll();

                for(int j = 0; j < n; j++) {
                    if(isConnected[city][j] == 1 && !visited[j]) {
                        visited[j] = true;
                        queue.offer(j);
                    }
                }
            }
        }

        return provinces;
    }
}
