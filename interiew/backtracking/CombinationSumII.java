package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> result (int candidates[], int target) {
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        int index = 0;

        dfs(index, candidates, target, new ArrayList<>(), result);

        return result;
    }

    private void dfs(int index, int[] candidates, int target, List<Integer> path, List<List<Integer>> result) {
        
        if(target == 0) {
            result.add(new ArrayList<>(path));

            return;
        }

        for(int i = index; i < candidates.length; i++) {
            
            if(i > index && candidates[i] == candidates[i - 1]) continue;

            if(candidates[i] > target) break;
            
            path.add(candidates[i]);

            dfs(i + 1, candidates, target - candidates[i], path, result);

            path.remove(path.size() - 1);
        }
    }


}
