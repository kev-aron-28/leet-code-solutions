
import java.util.ArrayList;
import java.util.List;

public class Exam11 {
    public List<List<Integer>> subsets(int nums[]) {
        List<List<Integer>> result = new ArrayList<>();

        subsetsHelper(0, nums, new ArrayList<>(), result);

        return result;
    }

    private void subsetsHelper(int start, int nums[], List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for(int i = 0; i < nums.length; i++) {
            current.add(nums[i]);

            subsetsHelper(i + 1, nums, current, result);

            current.remove(current.size() - 1);
        }
    }
}
