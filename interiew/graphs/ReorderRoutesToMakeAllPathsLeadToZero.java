package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReorderRoutesToMakeAllPathsLeadToZero {
    record Pair(
        int node,
        int cost
    ) {}

    public int solution(int n, int[][] connections) {
        Map<Integer, List<Pair>> graph = new HashMap<>();

        for(int conn[] : connections) {
            int a = conn[0];
            int b = conn[1];

            graph.putIfAbsent(b, new ArrayList<>());
            graph.putIfAbsent(a, new ArrayList<>());

            graph.get(a).add(new Pair(b, 1));
            graph.get(b).add(new Pair(a, 0));
        }

        return dfs(0, new HashSet<>(), graph);
    }

    private int dfs(int node, Set<Integer> visited, Map<Integer, List<Pair>> graph) {
        visited.add(node);

        int changes = 0;

        for(Pair n : graph.get(node)) {
            int next = n.node();
            int cost = n.cost();

            if(!visited.contains(next)) {
                changes+= cost;
                changes+= dfs(next, visited, graph);
            }
        }

        return changes;
    } 
}
