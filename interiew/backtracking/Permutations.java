
import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> solution(int nums[]) {
        List<List<Integer>> result = new ArrayList<>();
        boolean used[] = new boolean[nums.length];

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

            used[i] = true;
            path.add(nums[i]);

            dfs(nums, path, used, result);
        
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}