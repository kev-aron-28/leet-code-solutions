package marathons.backtracking-1;

import java.util.ArrayList;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> solution(int nums[]) {
        List<List<Integer>> result = new ArrayList<>();

        subset(nums, 0, new ArrayList<>(), result);

        return result;
    }

    private void subset(int[] nums, int idx, List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));

        for(int i = idx; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            path.add(nums[i]);

            subset(nums, i + 1, path, result);

            path.remove(path.size() - 1);
        }
    }
}
