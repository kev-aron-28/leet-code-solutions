import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOrage {
    public int solution(int grid[][]) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        int fresh = 0;

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c] == 2) {
                    queue.offer(new int[] { r,c });
                } else if(grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        if(fresh == 0) return 0;

        int minutes = 0;

        int directions[][] = { { 1,0 }, {-1,0}, {0,1}, {0,-1}  };

        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean infected = false;

            for(int i = 0; i < size; i++) {
                int pos[] = queue.poll();

                for(int direction[] : directions) {
                    int nr = pos[0] + direction[0];
                    int nc = pos[1] + direction[1];

                    if(
                        nr >= 0 && nr < rows &&
                        nc >= 0 && nc < cols &&
                        grid[nr][nc] == 1
                    ) {
                        grid[nr][nc] = 2;
                        queue.offer(new int[] { nr, nc });

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
