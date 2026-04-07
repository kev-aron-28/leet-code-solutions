package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> solution (int nums[]) {
        List<List<Integer>> result = new ArrayList<>();

        boolean used[] = new boolean[nums.length];

        Arrays.sort(nums);

        dfs(nums, new ArrayList<>(), used, result);

        return result;
    }

    private void dfs(int nums[], List<Integer> path, boolean used[], List<List<Integer>> result) {
        if(path.size() == nums.length) {
            result.add(new ArrayList<>(path));

            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(used[i]) continue;

            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            path.add(nums[i]);

            dfs(nums, path, used, result);

            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
