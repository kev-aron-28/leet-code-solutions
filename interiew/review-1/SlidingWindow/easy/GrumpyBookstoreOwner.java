package review-1.SlidingWindow.easy;

public class GrumpyBookstoreOwner {
    public int solution(int customers[], int grumpy[], int minutes) {
        int baseSatisfied = 0;

        for(int i = 0; i < grumpy.length; i++) {
            if(grumpy[i] == 0) baseSatisfied += customers[i];
        }

        int windowSum = 0;

        int i;

        for(i = 0; i < minutes; i++) {
            if(grumpy[i] == 1) windowSum += customers[i];
        }

        int max = windowSum;

        while(i < grumpy.length) {
            if(grumpy[i] == 1) windowSum += customers[i];

            if(grumpy[i - minutes] == 1) windowSum -= customers[i - minutes];

            max = Math.max(max, windowSum);

            i++;
        }

        return max + baseSatisfied; 
    }
}
