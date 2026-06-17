package review-1.TwoPointers.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 3Sum {
    public List<List<Integer>> solution(int nums[]) {
        List<List<Integer>> result = new ArrayList<>();

        // Step 1. Sort
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int fixed = nums[i];

            int left = i + 1;
            int right = nums.length - 1;

            while(left < right) {
                int sum = fixed + nums[left] + nums[right];

                if(sum == 0) {
                    result.add(Arrays.asList(fixed, nums[left], nums[right]));
                    left++;
                    right--;
                    
                    while(left < right && nums[left] == nums[left - 1]) left++;
                    while(left < right && nums[right] == nums[right + 1]) right--;
                } else if(sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
