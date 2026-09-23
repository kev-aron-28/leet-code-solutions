
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> solution(int nums[]) {
        Set<Integer> set = new HashSet<>();

        for(int n : nums) {
            set.add(n);
        }

        int n = nums.length;
        
        List<Integer> result = new ArrayList<>();
        
        for(int i = 1; i <= n; i++) {
            if(!set.contains(i)) result.add(i);
        } 

        return result;
    }
}
