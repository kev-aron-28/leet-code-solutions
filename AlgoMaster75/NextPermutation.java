
import java.util.Arrays;

public class NextPermutation {
 
 //Find the next bigger number made from the same digits.
  public static void NextPermutation(int[] nums) {
    int len = nums.length;
    int pointer = len - 2;

    while(pointer >= 0 && nums[pointer] >= nums[pointer + 1]) {
      pointer--;
    }

    if(pointer >= 0) {
      int k = len - 1;

      while(nums[k] <= nums[pointer]) {
        k--;
      }

      int temp = nums[k];
      nums[k] = nums[pointer];
      nums[pointer] = temp;
    }

    int start = pointer + 1;
    int end = len - 1;

    while(start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }

  public static void main(String[] args) {
    int arr[] = { 1,2,3 };
    NextPermutation(arr);
    System.out.println(Arrays.toString(arr));
  }
}
