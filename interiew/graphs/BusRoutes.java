package graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BusRoutes {
    public int solution(int[][] routes, int source, int target) {
        if(source == target) return 0;

        Map<Integer, List<Integer>> map = new HashMap<>();


        for(int i = 0; i < routes.length; i++) {
            for(int stop : routes[i]) {
                map.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedBuses = new HashSet<>();
        
        visitedStops.add(source);
        queue.offer(source);

        int buses = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            buses++;

            for(int i = 0; i < size; i++) {
                int stop = queue.poll();

                for(int bus : map.getOrDefault(stop, new ArrayList<>())) {
                    if(visitedBuses.contains(bus)) continue;

                    visitedBuses.add(bus);

                    for(int nextStop : routes[bus]) {
                        if(nextStop == target) return buses;

                        if(!visitedStops.contains(nextStop)) {
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
