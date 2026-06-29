package review-1.PrefixSum.medium;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    public boolean solution(int nums[], int k) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int prefixSum = 0;

        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            int reminder = prefixSum % k;

            if (map.containsKey(reminder)) {
                if(i - map.get(reminder) >= 2) {
                    return true;
                }
            } else {
                map.put(reminder, i);
            }
        }

        return false;
    }
}
