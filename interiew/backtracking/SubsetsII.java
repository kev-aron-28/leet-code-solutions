package backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> solution (int nums[]) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(0, nums, new ArrayList<>(), result);

        return result;
    }

     private void dfs(int index, int nums[], List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));

        for(int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i - 1]) continue;

            path.add(nums[i]);

            dfs(i + 1, nums, path, result);

            path.remove(path.size() - 1);
        }
    }
}
