package graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class NearestExitFromEntranceInMaze {
    public int solution(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { entrance[0], entrance[1] });

        maze[entrance[0]][entrance[1]] = '+';

        int directions[][] = { {1,0}, {-1,0}, {0,1}, {0,-1} };

        int steps = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                int cell[] = queue.poll();

                int r = cell[0];
                int c = cell[1];

                if( (r == 0 || c == 0 || r == m - 1 || c == n - 1 ) && !(r == entrance[0] && c == entrance[1])) {
                    return steps;
                }

                for(int dir[] : directions) {
                    int row = r + dir[0];
                    int col = c + dir[1];

                    if(row >= 0 && row < m && col >= 0 && col < n && maze[row][col] == '.') {
                        maze[row][col] = '+';
                        queue.offer(new int[] { row, col });
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}
