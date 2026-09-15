package marathons.graphs-1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BusRoutes {
    public int solution(int [][] routes, int target, int source) {
            if(target == source) return 0;

            Map<Integer, List<Integer>> graph = new HashMap<>();
            
            int buses = 0;

            for(int bus = 0; bus < routes.length; bus++) {
                for(int stop : routes[bus]) {
                    graph.computeIfAbsent(stop, k -> new ArrayList<>()).add(bus);
                }
            }

            Queue<Integer> queue = new ArrayDeque<>();
            Set<Integer> visitedBuses = new HashSet<>();
            Set<Integer> visitedStops = new HashSet<>();

            visitedStops.add(source);
            queue.offer(source);

            while(!queue.isEmpty()) {
                int size = queue.size();

                buses++;
                for(int i = 0; i < size; i++) {
                    int stop = queue.poll();

                    for (int bus : graph.getOrDefault(stop, new ArrayList<>())) {
                        if(visitedBuses.contains(bus)) continue;

                        visitedBuses.add(bus);
                        for(int nextStop : routes[bus]) {
                            if(nextStop == target) return buses;
                            
                            if (!visitedStops.contains(nextStop)) {
                                visitedStops.add(nextStop);
                                queue.offer(nextStop);
                            }
                        }
                    }
                }
            }

            return -1;
    }
}
