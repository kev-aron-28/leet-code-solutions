package review-2;

public class BestTimeToBuyAndSellStock {
    public int solution(int prices[]) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int p : prices) {
            if (p < minPrice) {
                minPrice = p;
            }

            maxProfit = Math.max(maxProfit, p - minPrice);
        }

        return maxProfit;
    }
}
