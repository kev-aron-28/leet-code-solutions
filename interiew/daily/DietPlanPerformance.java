package daily;

public class DietPlanPerformance {
    public int solution(int calories[], int k, int lower, int upper) {
        int score = 0;
        int window = 0;

        for(int i = 0; i < k; i++) {
            window += calories[i];
        }

        if(window < lower) {
            score--;
        } else if(window > upper) {
            score++;
        }

        for(int i = k; i < calories.length; i++) {
            window += calories[i];
            window -= calories[i - k];

            if(window < lower) score--;
            else if (window > upper) score++;
        }

        return score;
    } 
}
