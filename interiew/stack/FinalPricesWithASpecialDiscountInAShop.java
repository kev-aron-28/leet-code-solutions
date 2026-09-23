package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class FinalPricesWithASpecialDiscountInAShop {
    public int[] solution(int prices[]) {
        int n = prices.length;

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            int currentPrice = prices[i];

            while (!stack.isEmpty() && prices[stack.peek()] >= currentPrice) { 
                int index = stack.pop();
                prices[index] = prices[index] - currentPrice;
            }

            stack.push(i);
        }

        return prices;
    }
}
