public class DietPlanPerformance {
    public static int diet(int calories[], int k, int lower, int upper) {
        int points = 0;

        int sumWindow = 0;

        for(int i = 0; i < k; i++) {
            sumWindow += calories[i];
        }

        if (sumWindow < lower) {
            points--;
        } else if (sumWindow > upper) {
            points++;
        }

        for(int i = k; i < calories.length; i++) {
            sumWindow += calories[i] - calories[i - k];

            if (sumWindow < lower) {
                points--;
            } else if (sumWindow > upper) {
                points++;
            }
        }


        return points;
    } 
    
    public static void main(String[] args) {
        
    }
}
