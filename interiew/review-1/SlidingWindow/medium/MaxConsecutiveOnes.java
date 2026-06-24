package review-1.SlidingWindow.medium;

public class MaxConsecutiveOnes {
    public int solution(int nums[]) {
        int current = 0;
        int max = 0;
        
        for(int num : nums) {
            if(num == 1) {
                current++;
                max = Math.max(max,current);
            } else {
                current = 0;
            }
        }

        return max;
    }
}
