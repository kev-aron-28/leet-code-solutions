package marathons.backtracking-1;

import java.util.ArrayList;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> solution(int nums[]) {
        boolean used[] = new boolean[nums.length];

        List<List<Integer>> result = new ArrayList<>();

        permutations(nums, used, new ArrayList<Integer>(), result);

        return result;
    }

    private void permutations(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> result) {
        if(path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(used[i]) continue;

            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            path.add(nums[i]);

            permutations(nums, used, path, result);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
