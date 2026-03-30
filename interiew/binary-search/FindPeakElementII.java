package binary-search;

public class FindPeakElementII {
    public int[] solution(int mat[][]) {
        int rows = mat.length;
        int cols = mat[0].length;

        int left = 0;
        int right = cols - 1;

        while (left <= right) { 
            int midCol = left + (right - left) / 2;
        
            int maxRow = 0;
            for(int r = 0; r < rows; r++) {
                if (mat[r][midCol] > mat[maxRow][midCol]) {
                    maxRow = r;
                }
            }

            int leftVal = (midCol - 1 >= 0) ? mat[maxRow][midCol - 1] : -1;
            int rightVal = (midCol + 1 < cols) ? mat[maxRow][midCol + 1] : -1;

            if(mat[maxRow][midCol] > leftVal && mat[maxRow][midCol] > rightVal) {
                return new int[] { maxRow, midCol };
            } else if(leftVal > mat[maxRow][midCol]) {
                right = midCol - 1;
            } else {
                left = midCol + 1;
            }
            
            
        }

        return new int[] { -1, -1 };
    }
}
