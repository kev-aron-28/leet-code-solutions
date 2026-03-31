package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationsSumIII {
    public List<List<Integer>> solution(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(1, k, n, new ArrayList<>(), result);

        return result;
    }

    private void dfs(int index,int k, int n, List<Integer> path, List<List<Integer>> result) {
        if(path.size() == k && n == 0) {
            result.add(new ArrayList<>(path));
            
            return;
        }

        if(path.size() > k || n < 0) return;

        for(int i = index; i <= 9; i++) {
            path.add(i);

            dfs(i + 1, k, n - i, path, result);

            path.remove(path.size() - 1);
        }
    }
}
