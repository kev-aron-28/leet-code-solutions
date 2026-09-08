
import java.util.HashSet;
import java.util.Set;

public class FindDuplicatesII {
    public boolean solution(int nums[], int k) {
        Set<Integer> window = new HashSet<>();

        for(int right = 0; right < nums.length; right++) {
            if(window.contains(nums[right])) {
                return true;
            }

            window.add(nums[right]);

            if(right >= k) {
                window.remove(nums[right - k]);
            }
        }

        return false;
    }
}
