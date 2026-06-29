package review-1.PrefixSum.easy;

public class MaximumPopulationYear {
    public int solution(int logs[][]) {
        int diff[] = new int[2051];

        for(int log[]: logs) {
            diff[log[0]]++;
            diff[log[1]]--;
        }

        int population = 0;
        int max = 0;
        int year = 0;


        for(int i = 1950; i < 2051; i++) {
            population += diff[i];

            if(population > max) {
                max = population;
                year = i;
            }
        }

        return year;
    }
}
