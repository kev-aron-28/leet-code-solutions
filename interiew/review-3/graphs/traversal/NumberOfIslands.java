package review

import java.util.ArrayDeque;
import java.util.Queue;

-3.graphs.traversal;

public class NumberOfIslands {
    public int solution(char [][] grid) {
        int islands = 0;

        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == '1') {
                    islands++;
                    findConnectedLand(grid, r, c);
                }
            }
        }

        return islands;
    }

    public void findConnectedLand(char grid[][], int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        if(r < 0 || c < 0 || r >= rows || c >= cols) {
            return;
        }

        if(grid[r][c] == '0') return;
        
        grid[r][c] = '0';
        // To the right
        findConnectedLand(grid, r + 1, c);
        // To the left
        findConnectedLand(grid, r - 1, c);
        // To the top
        findConnectedLand(grid, r, c + 1);
        // bottom
        findConnectedLand(grid, r, c - 1);
    }

    public int solutionBFS(char grid[][]) {
        int rows = grid.length;
        int cols = grid[0].length;

        int islands = 0;

        int[][] directions = {
            { 0,1 },
            {0,-1},
            {1,0},
            {-1,0}
        };

        Queue<int[]> queue = new ArrayDeque<>();

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c] == '1') {
                    islands++;

                    queue.offer(new int[] { r, c });

                    grid[r][c] = '0';

                    while(!queue.isEmpty()) {
                        int current[] = queue.poll();

                        int row = current[0];
                        int col = current[1];

                        for(int dir[] : directions) {
                            int nr = row + dir[0];
                            int nc = col + dir[1];

                            if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == '1') {
                                grid[nr][nc] = '0';
                                queue.offer(new int[]{nr, nc});
                            }
                        }
                    }
                }
            }
        }

        return islands;
    }
}
