package review-3.graphs.traversal;

import java.util.ArrayDeque;
import java.util.Queue;


public class MaxAreaOfIsland {
    public int solution(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length; 
        
        int max = 0;

        Queue<int[]> queue = new ArrayDeque<>();

        int directions[][] = new int[][] {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
        };

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c] == 1) {
                    int area = 1;
                    
                    queue.add(new int[] { r,c });

                    while(!queue.isEmpty()) {
                        int current[] = queue.poll();

                        int x = current[0];
                        int y = current[1];

                        grid[r][c] = 0;

                        for(int dir[] : directions) {
                            int nX = x + dir[0];
                            int nY = y + dir[1];
                            
                            if(
                                nX >= 0 && nX < rows &&
                                nY >= 0 && nY < cols &&
                                grid[nX][nY] == 1
                            ) {
                                area++;
                                grid[nX][nY] = 0;
                                queue.offer(new int[] { nX, nY });
                            }
                        }
                    }

                    max = Math.max(area, max);
                }
            }
        }

        return max;
    }
}
