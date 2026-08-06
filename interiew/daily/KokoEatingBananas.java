package daily;

public class KokoEatingBananas {
    pulbic int solution(int piles[], int h) {
        int left = 1;
        int right = 0;

        for(int p : piles) {
            right = Math.max(p, right);
        }

        while(left < right) {
            int mid = left + (right - left) / 2;

            if(canFinish(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        
        return left;
    }

    private boolean canFinish(int piles[], int k, int h) {
        int hours = 0;

        for(int pile : piles) {
            hours += (int)Math.ceil((double)pile / (double)k);
        }

        return hours <= h;
    }
}
