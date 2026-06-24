package review-1.SlidingWindow.medium;

public class MinimumSizeSubarraySum {
    public int solution(int target, int nums[]) {
        int currentWindowSum = 0;
        
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        for(int right = 0; right < nums.length; right++) {
            currentWindowSum += nums[right];

            while (currentWindowSum >= target) { 
                minLen = Math.min(minLen, right - left + 1);
                currentWindowSum -= nums[left];

                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
