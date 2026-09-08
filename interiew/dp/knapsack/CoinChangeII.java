package dp.knapsack;

public class CoinChangeII {
    public int solution(int coins[], int amount) {
        int dp[] = new int[amount + 1];

        dp[0] = 1;

        for(int coin : coins) {
            for(int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }
}
