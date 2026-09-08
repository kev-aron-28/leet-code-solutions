
import java.util.TreeSet;

public class ContainsDuplicateIII {
    public boolean solution(int nums[], int indexDiff, int valueDiff) {
        TreeSet<Integer> tree = new TreeSet<>();

        for(int right = 0; right < nums.length; right++) {
            int current = nums[right];

            Integer candidate = tree.ceiling(current - valueDiff);

            if(candidate != null && candidate <= current + valueDiff) {
                return true;
            }

            tree.add(current);

            if (right >= indexDiff) {
                tree.remove(nums[right - indexDiff]);
            }
        }

        return false;
    }
}
