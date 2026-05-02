package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarFrOmLandAsPossible {
    public int solution(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    queue.offer(new int[] { i, j });
                }
            }
        }

        if(queue.isEmpty() || queue.size() == n * n) {
            return -1;
        }

        int distance = -1;

        int directions[][] = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };

        while (!queue.isEmpty()) { 
            int size = queue.size();
            distance++;

            for(int i = 0; i < size; i++) {
                int cell[] = queue.poll();
                
                for(int dir[]: directions) {
                    int x = cell[0] + dir[0];
                    int y = cell[1] + dir[1];

                    if(x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0) {
                        grid[x][y] = 1;
                        queue.offer(new int[] { x,y });
                    }
                }

            }
        }

        return distance;
    }
}
