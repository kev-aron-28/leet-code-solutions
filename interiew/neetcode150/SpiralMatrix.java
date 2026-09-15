package neetcode150;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> solution(int matrix[][]) {
        List<Integer> result = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while(top <= bottom && left <= right) {
            // Left => Right
            for(int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }

            top++;

            // Top -> Bottom
            for(int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }

            right--;

            // Right -> left
            if (top <= bottom) {
                for(int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--;
            }

            // bottom -> top
            if (left <= right) {
                for(int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }

                left++;
            }
        }

        return result;
    }
}
