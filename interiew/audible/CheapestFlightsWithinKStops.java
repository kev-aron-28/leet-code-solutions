package audible;
import java.util.*;

public class CheapestFlightsWithinKStops {
    public int solution(int n, int flights[][], int src, int dst, int k) {
        int INF = Integer.MAX_VALUE;
        int cost[] = new int[n];

        Arrays.fill(cost, INF);
        cost[src] = 0;

        for(int i = 0; i <= k; i++) {
            int next[] = cost.clone();

            for(int flight[] : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];

                if(cost[from] == INF) continue;
                
                next[to] = Math.min(
                    next[to],
                    cost[from] + price
                );

            }
            cost = next;
        }

        return cost[dst] == INF ? -1 : cost[dst];
    }
}
