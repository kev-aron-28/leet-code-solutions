package binary-search;

public class CapacityToShipPackagesWithinDDays {
    public int solution(int weights[], int days) {
        int minWeight = 0;
        int maxWeight = 0;

        for(int w : weights) {
            minWeight = Math.max(minWeight, w);
            maxWeight += w;
        }

        while(minWeight < maxWeight) {
            int mid = minWeight + (maxWeight - minWeight) / 2;

            if(canShip(weights, days, mid)) {
                maxWeight = mid;
            } else {
                minWeight = mid + 1;
            }
            
        }

        return minWeight;
    }

    public boolean canShip(int weights[], int days, int capacity) {

        int daysNeeded = 1;
        int currentW = 0;

        for(int w : weights) {
            if(currentW + w > capacity) {
                daysNeeded++;
                currentW = 0;
            }

            currentW += w;
        }
        
        return daysNeeded <= days;
    }
}
