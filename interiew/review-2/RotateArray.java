package review-2;

public class RotateArray {
    public void rotate(int nums[], int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    } 

    public void reverse(int n[], int left, int right) {
        while (left < right) { 
            int temp = n[left];
            n[left] = n[right];
            n[right] = temp;
            left++;
            right--;
        }
    }
}
