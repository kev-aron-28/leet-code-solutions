package common;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> solution(int candidates[], int target) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(0, candidates, target, new ArrayList<>(), result);

        return result;
    } 

    private void dfs(int index, int candidates[], int target, List<Integer> path, List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        if(target < 0) return;

        for(int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);

            dfs(i, candidates, target - candidates[i], path, result);

            path.remove(path.size() - 1);
        }
    }
}
