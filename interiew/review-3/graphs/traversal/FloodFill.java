package review-3.graphs.traversal;

import java.util.ArrayDeque;
import java.util.Queue;


public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length;
        int cols = image[0].length;

        int originalColor = image[sr][sc];

        if(originalColor == color) return image;

        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.add(new int[] { sr, sc });

        image[sr][sc] = color;
                                //top  // down  //right //left
        int[][] directions = { {0, 1}, {0,-1}, {1,0}, {-1,0}};

        while(!queue.isEmpty()) {
            int pos[] = queue.poll();

            int x = pos[0];
            int y = pos[1];

            for(int direction[] : directions) {
                int nX = x + direction[0];
                int nY = y + direction[1];

                if(
                    nX >= 0 && nX < rows && nY >= 0 && nY < cols
                    && image[nX][nY] == originalColor
                ) {
                    image[nX][nY] = color;

                    queue.add(new int[] { nX, nY });
                }
            }

        }

        return image;
    }
}
