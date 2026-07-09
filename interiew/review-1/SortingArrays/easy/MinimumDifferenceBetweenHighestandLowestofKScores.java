package review-1.SortingArrays.easy;

import java.util.Arrays;

public class MinimumDifferenceBetweenHighestandLowestofKScores {
    public int solution(int nums[], int k) {
        if(k == 1) return 0;
        
        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;

        for(int highest = k - 1; highest < nums.length; highest++) {
            int lowest = highest - k + 1;

            min = Math.min(min, nums[highest] - nums[lowest]);

        }

        return min;
    }
}
