package dp.basic1dp.medium;

public class DecodeWays {
    public int solution(String s) {
        int n = s.length();
        int dp[] = new int[n + 1];

        dp[0] = 1;

        for(int i = 1; i <= n; i++) {
            char current = s.charAt(i - 1);

            if(current >= '1' && current <= '9') {
                dp[i] += dp[i - 1];
            }

            if(i >= 2) {
                int number = Integer.parseInt(s.substring(i - 2, i));

                if(number >= 10 && number <= 26) {
                    dp[i] += dp[i - 2];   
                }
            }
        }

        return dp[n];
    }
}
