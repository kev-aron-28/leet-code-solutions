package review-1.SortingArrays.easy;

import java.util.Arrays;

public class ArrayPartition {
    public int solution(int nums[]) {
        Arrays.sort(nums);
        int result = 0;

        for(int i = 0; i < nums.length; i+=2) {
            result += nums[i];
        }

        return result;
    }
}
