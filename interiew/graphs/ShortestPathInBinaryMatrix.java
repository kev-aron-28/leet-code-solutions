package graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public int solution(int grid[][]) {
        int size = grid.length;

        if(grid[0][0] == 1 || grid[size - 1][size - 1] == 1) return -1;

        int directions[][] = {
            { 1,0 },{-1,0},{0,-1},{0,1},
            {1,1},{1,-1},{-1,1},{-1,-1}
        };

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { 0,0,1 });

        grid[0][0] = 1;

        while (!queue.isEmpty()) { 
            int curr[] = queue.poll();
            int row = curr[0], col = curr[1], dis = curr[2];

            if(row == size - 1 && col == size - 1 ) {
                return dis;
            }

            for(int dir[] : directions) {
                int testRow = row + dir[0];
                int testCol = col + dir[1];

                if(testRow >= 0 && testRow < size && testCol >= 0 && testCol < size && grid[testRow][testCol] == 0) {
                    queue.offer(new int[] { testRow, testCol, dis + 1 });
                    grid[testRow][testCol] = 1;
                }
            }

        }

        return -1;
    } 
}
