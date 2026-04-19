package backtracking;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> solution(int graph[]) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0);



        return result;
    }

    private void dfs(int node, int graph[][], List<Integer> path, List<List<Integer>> result) {
        if(node == graph.length - 1) {
            result.add(new ArrayList<>(path));

            return;
        }

        for(int next : graph[node]) {
            path.add(next);

            dfs(next, graph, path, result);

            path.remove(path.size() - 1);
        }
    } 
}
