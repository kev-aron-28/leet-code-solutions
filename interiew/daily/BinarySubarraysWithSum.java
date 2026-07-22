package daily;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum {
    public int solution(int nums[], int goal) {
        Map<Integer, Integer> count = new HashMap<>();

        count.put(0, 1);

        int prefix = 0;
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            prefix += nums[i];

            if(count.containsKey(prefix - goal)) {
                result += count.get(prefix - goal);
            }

            count.put(prefix, count.getOrDefault(prefix, 0) + 1);
        }

        return result;
    } 
}
