package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> result(int nums[], int target) {
        List<List<Integer>> result = new ArrayList<>();
        

        dfs(0, nums, target, new ArrayList<>(), result);

        return result;
    }

    private void dfs(int index, int nums[], int target, List<Integer> path, List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<>(path));

            return;
        }

        if(target < 0) return;

        for(int i = index; i < nums.length; i++) {
            path.add(nums[i]);

            dfs(i, nums, target - nums[i], path, result);

            path.remove(path.size() - 1);
        }
    }
}
