
public class SplitArrayLargestSum {
    public int solution(int nums[], int k) {
        int left = 0;
        int right = 0;

        for(int n : nums) {
            left = Math.max(left, n);
            right += n;
        }

        while (left < right) { 
            int mid = left + (right - left) / 2;

            if(canSplit(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canSplit(int nums[], int k, int maxSum) {
        
        int sum = 0;
        int pieces = 1;

        for(int n : nums) {
            if(sum + n > maxSum) {
                pieces++;
                sum = n;
            } else {
                sum += n;
            }
        }
        
        return pieces <= k;
    } 
}
