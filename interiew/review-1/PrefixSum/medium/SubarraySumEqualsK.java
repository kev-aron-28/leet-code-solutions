package review-1.PrefixSum.medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int solution(int nums[], int k ) {
        Map<Integer, Integer> map = new HashMap<>();
        
        map.put(0, 1);

        int prefix = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            prefix += nums[i];

            if(map.containsKey(prefix - k)) {
                count += map.get(prefix - k);
            }

            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }

        return count;
    }
}
