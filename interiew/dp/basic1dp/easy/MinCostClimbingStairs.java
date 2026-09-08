package dp.basic1dp.easy;

public class MinCostClimbingStairs {
    public int solution(int cost[]) {
       int n = cost.length;
       int dp[] = new int[n + 1];

       for(int i = 2; i <= n; i++) {
            // OPTION 1: 
            // Reach i from i - 1
            // dp[i - 1] = cost we already paid to reach i - 1
            // cost[i - 1] = cost of the stair we are leaving
            // we paid dp[2] to reach 2
            // they pay cost[2] to leav tair 2
            int oneStep = dp[i - 1] + cost[i - 1];

            int twoStep = dp[i - 2] + cost[i - 2];

            dp[i] = Math.min(oneStep, twoStep);
       }

       return dp[n];
    }
}
