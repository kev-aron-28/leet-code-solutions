package review-1.TwoPointers.easy;

public class SquaresOfSortedArray {
    public int[] solution(int nums[]) {
        int result[] = new int[nums.length];

        int pos = nums.length - 1;
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if(leftSquare > rightSquare) {
                result[pos--] = leftSquare;
                left++;
            }  else {
                result[pos--] = rightSquare;
                right--;
            }
        }

        return result;
    }
}
