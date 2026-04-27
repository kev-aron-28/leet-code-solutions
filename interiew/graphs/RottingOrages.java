package graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOrages {
    public int solution(int grid[][]) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        int fresh = 0;

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c] == 2) {
                    queue.offer(new int[] { r, c});
                } else if(grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        if(fresh == 0) return 0;

        int minutes = 0;

        int directions[][] = { { 1,0 },{-1,0},{0,1},{0,-1}};

        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean infected = false;

            for(int i = 0; i < size; i++) {
                int curr[] = queue.poll();

                for(int dir[] : directions) {
                    int row = curr[0] + dir[0];
                    int col = curr[1] + dir[1];

                    if(row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        queue.offer(new int[] { row, col });
                        fresh--;
                        infected = true;
                    }
                }
            }

            if(infected) minutes++;
        } 
 
        return fresh == 0 ? minutes : -1;
    }
}
