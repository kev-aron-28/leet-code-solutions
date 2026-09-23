package neetcode150;

import java.util.ArrayDeque;
import java.util.Queue;

public class SetMatrixZeroes {
    public void solution(int matrix[][]) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check first row
        for(int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Check first col
        for(int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Set markers
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set rows marked 0
        for(int i = 1; i < m; i++) {
            if(matrix[i][0] == 0) {
                for(int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Set cols marked 0

        for(int j = 1; j < n; j++) {
            if(matrix[0][j] == 0) {
                for(int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRowZero) {
            for(int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if (firstColZero) {
            for(int i = 0; i < m; i ++) {
                matrix[i][0] = 0;
            }
        }

    }
}