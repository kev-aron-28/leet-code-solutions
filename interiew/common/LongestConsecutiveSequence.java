package common;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int solution(int nums[]) {
        Set<Integer> set = new HashSet<>();

        for(int n : nums) set.add(n);

        int result = 0;

        for(int num : set) {
            if(!set.contains(num - 1)) {
                int currentNum = num;
                int streak = 1;

                while (set.contains(currentNum + 1)) { 
                    currentNum++;
                    streak++;
                }

                result = Math.max(result, streak);
            }
        }

        return 0;
    }
}
