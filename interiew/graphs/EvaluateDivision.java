package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {
    record Pair(
        String node,
        double val
    ) {}

    Map<String, List<Pair>> graph = new HashMap<>();

    public double[] solution(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result =  new double[queries.size()];


        for(int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());

            graph.get(a).add(new Pair(b, val));

            graph.get(b).add(new Pair(a, 1/val));
        }

        for(int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);

            if(!graph.containsKey(a) || !graph.containsKey(b)) {
                result[i] = -1.0;
            } else {
                result[i] = dfs(a, b, 1.0, new HashSet<>());
            }

        }


        return result;
    }

    private double dfs(String current, String target, double product, Set<String> visited) {
        if(current.equals(target)) return product;

        visited.add(current);

        for(Pair nei : graph.get(current)) {
            if(!visited.contains(nei.node())) {
                double res = dfs(nei.node(), target, product * nei.val(), visited);
            
                if(res != -1) return res;
            }
        }

        return -1.0;
    }
}
