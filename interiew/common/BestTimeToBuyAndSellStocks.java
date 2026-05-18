package common;

public class BestTimeToBuyAndSellStocks {
    public int solution(int prices[]) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price : prices) {
            if(price < minPrice) {
                minPrice = price;
            }

            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }
}
