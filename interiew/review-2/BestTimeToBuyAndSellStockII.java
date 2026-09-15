package review-2;

public class BestTimeToBuyAndSellStockII {
    public int solution(int prices[]) {
        int profit = 0;

        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i - 1]){
                profit +=  prices[i] - prices[i - 1];
            }
        }

        return profit;
    }
}
