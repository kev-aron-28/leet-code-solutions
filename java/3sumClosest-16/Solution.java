
import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int smallestDif = Integer.MAX_VALUE;
        int result = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = left - 1;
            while (left < right) { 
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs((sum - target));

                if(diff < smallestDif) {
                    smallestDif = diff;
                    result = sum;
                }
                
                if(sum == target) {
                    return sum;
                } else if(sum < target) {
                    left++;
                } else {
                    right++;
                }
            }
        }

        return result;
    }
} 