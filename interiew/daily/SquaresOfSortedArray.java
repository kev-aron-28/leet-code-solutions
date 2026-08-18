package daily;

public class SquaresOfSortedArray {
    public int[] solution(int nums[]) {
        int n = nums.length;
        int result[]  = new int[n];

        int idx = n - 1;

        int left = 0;
        int right = n - 1;

        while(left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if(rightSquare > leftSquare) {
                result[idx--] = rightSquare;
                right--;
            } else {
                result[idx--] = leftSquare;
                left++;
            }
        } 

        return result;
    }    
}
