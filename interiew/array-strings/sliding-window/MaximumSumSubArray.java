public class MaximumSumSubArray {
    public static int maxSum(int nums[], int k) {
        int sumWindow = 0;

        for(int i = 0; i < k; i++) {
            sumWindow += nums[i];
        }

        int max = sumWindow;

        for(int i = k; i < nums.length; i++) {
            sumWindow += nums[i] - nums[i - k];

            max = Math.max(sumWindow, max);
        }

        return max;
    }
    
    public static void main(String[] args) {
        
    }
}
