package binary-search;

public class KokoLovesToEatBananas {
    public int solution (int piles[], int h) {
        // how fast should koko eat (K)
        // Or how many bananas per hour to finish all of the piles in under or equal to 8 hours

        int minBananasPerHour = 1;
        int maxBananasPerHour = 0;

        for(int pile : piles ){
            maxBananasPerHour = Math.max(maxBananasPerHour, pile);
        }


        while (minBananasPerHour < maxBananasPerHour) { 
            int mid = minBananasPerHour + (maxBananasPerHour - minBananasPerHour) / 2;

            if(canFinish(piles, h, mid)) {
                maxBananasPerHour = mid;
            } else {
                minBananasPerHour = mid + 1;
            }
        }

        return minBananasPerHour;
    }

    // SHould return the total hours it will take 
    // to eat all the piles if we choose K bananas per hour
    public boolean canFinish(int piles[], int h, int k) {
        int hours = 0;

        for(int pile : piles) {
            hours += (int)Math.ceil((double)pile / (double)k);
        }

        return hours <= h;
    }
}
