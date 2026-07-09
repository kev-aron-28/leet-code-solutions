package review-1.SortingArrays.easy;

import java.util.Arrays;

public class HeightChecker {
    public int solution(int heights[]) {
        int expected[] = Arrays.copyOf(heights, heights.length);

        Arrays.sort(expected);
        
        int count = 0;
        for(int i = 0; i < heights.length; i++) {
            if(expected[i] != heights[i]) count++;
        }

        return count;
    }
}
