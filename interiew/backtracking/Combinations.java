package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> solution(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(1, n, k, new ArrayList<>(), result);

        return result;
    }


    private void dfs(int index, int n, int k, List<Integer> path, List<List<Integer>> result) {

        if(path.size() == k) {
            result.add(new ArrayList<>(path));

            return;
        }

        for(int i = index; i <= n; i++) {
            path.add(i);

            dfs(i + 1, n, k, path, result);

            path.remove(path.size() - 1);
        }
    }
}
