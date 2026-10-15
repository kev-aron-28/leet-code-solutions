import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public int solution(int grid[][]) {
        int size = grid.length;

        if(grid[0][0] == 1 || grid[size - 1][size - 1] == 1) return -1;

        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[] { 0,0,1 });

        grid[0][0] = 1;

        int directions[][] = {
            { 1,0 },{-1,0},{0,-1},{0,1},
            {1,1},{1,-1},{-1,1},{-1,-1}
        };

        while(!queue.isEmpty()) {
            int position[] = queue.poll();
            int r = position[0];
            int c = position[1];
            int distance = position[2];

            if(r == size - 1 && c == size - 1) {
                return distance;
            }


            for(int direction[] : directions) {
                int nr = r + direction[0];
                int nc = c + direction[1];

                if(nr >= 0 && nr < size &&
                    nc >= 0 && nc < size &&
                    grid[nr][nc] == 0
                ) {
                    queue.offer(new int[] { nr, nc, distance + 1 });

                    grid[nr][nc] = 1;
                }
            }
        }

        return -1;
    }
}
