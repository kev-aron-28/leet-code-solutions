public class SortedSquare {
    public static int[] sortedSquares(int nums[]) {
        int len = nums.length;
        int result[] = new int[len];

        int left = 0;
        int right = len - 1;
        int position = len - 1;

        while (left < right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if(leftSquare > rightSquare) {
                result[position--] = leftSquare;
                left++;
            } else {
                result[position--] = rightSquare;
                right--;
            }
        }

        return result;
    }
    
    public static void main(String[] args) {
        int nums[] = { -7, -3, 2, 3, 11 };
        
        for(int i : sortedSquares(nums)) {
            System.out.println(i);
        }
    }
}
