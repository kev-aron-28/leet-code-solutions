package marathons.graphs-1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {
    Map<String, Map<String, Double>> graph = new HashMap<>();

    public double[] solution(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Build the graph
        int index = 0;
        for(var equation : equations) {
            String a = equation.get(0);
            String b = equation.get(1);

            double value = values[index++];
            
            graph.computeIfAbsent(a, (z) -> new HashMap<>())
                .put(b, value);

            graph.computeIfAbsent(b, x -> new HashMap<>())
                .put(a, 1 / value);

        }

        double result[] = new double[queries.size()];

        index = 0;
        for(var query : queries) {
            String from = query.get(0);
            String target = query.get(1);

            if(!graph.containsKey(from) || !graph.containsKey(target)) {
                result[index++] = -1.0;
                continue;
            }

            result[index++] = dfs(from, target, 1.0, new HashSet<>());
        }

        return result;
    }

    private double dfs(String from, String target, double acc, HashSet<String> seen) {
        if(from.equals(target)) {
            return acc;
        }

        seen.add(from);

        for(var neigh : graph.get(from).entrySet()) {
            if(seen.contains(neigh.getKey())) {
                continue;
            }
            
            String neighbor = neigh.getKey();
            double value = neigh.getValue();

            double result = dfs(neighbor, target, acc * value, seen);

            if(result != -1.0) return result;

        }

        return -1.0;
    }
}
