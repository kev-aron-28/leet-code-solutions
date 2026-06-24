package review-1.SlidingWindow.easy;

public class MaximumAverageSubarray {
    public double solution(int nums[], int k) {
        int windowSum = 0;

        int right;

        for(right = 0; right < k; right++) {
            windowSum+= nums[right];
        }

        int max = windowSum;

        while(right < nums.length) {
            windowSum += nums[right] - nums[right - k];

            max = Math.max(windowSum, max);

            right++;
        }

        return (double)max / k;
    }
}
