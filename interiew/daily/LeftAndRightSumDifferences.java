package daily;

public class LeftAndRightSumDifferences {
    public int[] solution(int nums[]) {
        int n = nums.length;

        int result[] = new int[n];

        int sum = 0;

        for(int s : nums) {
            sum += s;
        }

        int leftSum = 0;
        
        for(int i = 0; i < n; i++) {
            int rightSum = sum - leftSum - nums[i];
            
            result[i] = Math.abs(rightSum - leftSum);

            leftSum += nums[i];
        }

        return result;
    }
}
