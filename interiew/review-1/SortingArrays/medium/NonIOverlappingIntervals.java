package review-1.SortingArrays.medium;

import java.lang.reflect.Array;
import java.util.Arrays;

public class NonIOverlappingIntervals {
    public int solution(int intervals[][]) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1],b[1]));


        int removed = 0;

        int prev = intervals[0][1];

        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < prev) {
                removed++;
            } else {
                prev = intervals[i][1];
            }
        }


        return removed;
    }
}
