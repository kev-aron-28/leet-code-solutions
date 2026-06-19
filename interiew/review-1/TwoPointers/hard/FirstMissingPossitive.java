package review-1.TwoPointers.hard;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPossitive {
    public int solution(int nums[]) {
        Set<Integer> set = new HashSet<>();

        for(int n : nums) {
            if(n > 0) set.add(n);
        }

        int candidate = 1;
        
        while(set.contains(candidate)) {
            candidate++;
        }

        return candidate;
    }
}
