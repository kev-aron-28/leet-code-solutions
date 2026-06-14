package review-1.HashMapSet.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int solution(int[] nums) {
        Set<Integer> elements = new HashSet<>();

        for(int n : nums) {
            elements.add(n);
        }

        int result = 0;

        for(int number : elements) {
            if(!elements.contains(number - 1)) {
                int current = number;
                int count = 1;

                while(elements.contains(number + 1)) {
                    current++;
                    count++;
                }

                result = Math.max(result, count);
            }
        }

        return result;
    }
}
