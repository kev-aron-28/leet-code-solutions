package neetcode150;

public class SearchA2DMatrix {
    public boolean solution(int matrix[][], int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;

        while (left <= right) { 
            int mid = left + (right - left) / 2;
            int row = mid / n;
            int col =  mid % n;

            int val = matrix[row][col];

            if (val == target) {
                return true;
            }

            if (target > val ) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
