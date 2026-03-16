package binary-search;

public class MinimumNumberOfDaysToMakeMBouquets {
    public int solution (int bloomDay[], int m, int k) {
        if((long)m * k > bloomDay.length) return -1;

        int minDaysOfWait = Integer.MAX_VALUE;
        int maxDaysOfWait = Integer.MIN_VALUE;

        for(int waitDays : bloomDay) {
            minDaysOfWait = Math.min(waitDays, minDaysOfWait);
            maxDaysOfWait = Math.max(waitDays, maxDaysOfWait);
        }

        while (minDaysOfWait < maxDaysOfWait) { 
            int daysToWait = minDaysOfWait + (maxDaysOfWait - minDaysOfWait) / 2;

            if(canMake(bloomDay, m, k, daysToWait)) {
                maxDaysOfWait = daysToWait;
            } else {
                minDaysOfWait = daysToWait + 1;
            }
        }

        return minDaysOfWait;
    }

    public boolean canMake(int bloomDay[], int m, int k, int daysOfWait) {
        int flowers = 0;
        int bouquets = 0;
        
        for(int day : bloomDay) {
            if(daysOfWait >= day) {
                flowers++;

                if(flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }

        return bouquets >= m;
    }
}
