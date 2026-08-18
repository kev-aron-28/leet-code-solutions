package marathons.backtracking-1;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> solution(int nums[]) {
        List<List<Integer>> result = new ArrayList<>();


        subset(nums, 0, new ArrayList<>(), result);

        return result;
    }

    public void subset(int nums[], int index, List<Integer> path,  List<List<Integer>> result) {
        result.add(new ArrayList<>(path));

        for(int i = index; i < nums.length; i++) {
            path.add(nums[i]);

            subset(nums, i + 1, path, result);
            
            path.remove(path.size() - 1);
        }
    }
}
