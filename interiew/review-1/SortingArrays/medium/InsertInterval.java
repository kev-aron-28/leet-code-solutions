package review-1.SortingArrays.medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public int[][] solution(int intervals[][], int newInterval[]) {
        int newIntervals[][] = Arrays.copyOf(intervals, intervals.length + 1);
        newIntervals[intervals.length + 1] = newInterval;

        Arrays.sort(newIntervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        int current[] = newIntervals[0];


        for(int i = 1; i < newIntervals.length; i++) {
            if(newIntervals[i][0] <= current[1]) {
                current[1] = Math.max(current[1], newIntervals[i][1]);
            } else {
                result.add(current);

                current = newIntervals[i];
            }
        }

        result.add(current);

        return result.toArray(new int[result.size()][]);
    }
}
