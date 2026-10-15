import java.util.ArrayDeque;
import java.util.Queue;

public class Matrix01 {
    public int[][] solution(int mat[][]) {
        int rows = mat.length;
        int cols = mat[0].length;

        Queue<int[]> queue = new ArrayDeque<>();

        int directions[][] = {
            {1,0},{-1,0},
            {0,1}, {0,-1}
        };

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(mat[r][c] == 0) {
                    queue.offer(new int[] { r, c });
                } else {
                    mat[r][c] = -1; // mark unvisited;
                }
            }
        }

        while(!queue.isEmpty()) {
            int position[] = queue.poll();
            int r = position[0];
            int c = position[1];

            for(int direction[] : directions) {
                int nr = r + direction[0];
                int nc = c + direction[1];

                if(
                    nr >= 0 && nr < rows &&
                    nc >= 0 && nc < cols &&
                    mat[nr][nc] == -1
                ) {
                    mat[nr][nc] = mat[r][c] + 1;

                    queue.offer(new int[] { nr,nc });
                }
            }
        }

        return mat;
    }
}
