package marathons.graphs-1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReorderRoutesToMakeAllPathsLeadtotheCityZero {
    record Pair(
        int node,
        int cost
    ) {}
    public int solution(int connections[][], int n) {
        Map<Integer, List<Pair>> graph = new HashMap<>();

        for(int connection[] : connections) {
            int a = connection[0];
            int b = connection[1];

            graph.computeIfAbsent(a, k -> new ArrayList<>());
            graph.computeIfAbsent(b, k -> new ArrayList<>());

            graph.get(a).add(new Pair(b, 1));
            graph.get(b).add(new Pair(a, 0));
        }

        return count(0, new HashSet<>(), graph);
    }

    public int count(int node, Set<Integer> visited, Map<Integer, List<Pair>> graph) {
        visited.add(node);

        int total = 0;
        for(Pair neigh : graph.get(node)) {
            int n = neigh.node;
            int cost = neigh.cost;

            if (!visited.contains(n)) {
                total += cost;
                total += count(n, visited, graph);
            }
        }


        return total;
    }
}
