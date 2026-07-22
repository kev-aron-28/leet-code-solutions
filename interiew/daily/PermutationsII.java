package daily;

import java.util.ArrayList;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> result(int nums[]) {
        List<List<Integer>> res = new ArrayList<>();

        boolean used[] = new boolean[nums.length];

        dfs(nums, used, new ArrayList<>(), res);

        return res;
    }

    private void dfs(int nums[], boolean used[], List<Integer> path, List<List<Integer>> result) {
        if(path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(used[i]) continue;

            if(i > 0 && nums[i] == nums[i - 1]) continue;

            used[i] = true;

            path.add(nums[i]);

            dfs(nums, used, path, result);

            used[i] = false;

            path.remove(path.size() - 1);
        }
    }
}
