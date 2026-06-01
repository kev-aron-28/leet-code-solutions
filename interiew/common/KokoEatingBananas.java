package common;

public class KokoEatingBananas {
    public int solution(int piles[], int h) {
        int left = 1;
        int right = 0;

        for(int pile : piles) {
            right = Math.max(pile, right);
        }

        while (left < right) { 
            int mid = left + (right - left) / 2;

            if(canFinish(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean canFinish(int piles[], int h, int k) {
        int hours = 0;

        for(int pile : piles) {
            hours += (int)Math.ceil((double)pile/(double)k);
        }

        return hours <= h;
    }
}
