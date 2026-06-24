package review-1.SlidingWindow.easy;

public class DietPlanPerformance {
    public int solution(int calories[], int k, int lower, int upper) {
        int windowSum = 0;
        int points = 0;
        int i;
        for(i = 0; i < k; i++) {
            windowSum += calories[i];
        }

        if(windowSum > lower) points--;
        if(windowSum < upper) points++;

        while (i < calories.length) { 
            windowSum += calories[i] - calories[i - k];

            if(windowSum > lower) points--;
            if(windowSum < upper) points++;

            i++;
        }

        return points;
    }
}
