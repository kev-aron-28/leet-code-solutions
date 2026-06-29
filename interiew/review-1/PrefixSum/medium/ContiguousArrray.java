package review-1.PrefixSum.medium;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArrray {
    public int solution(int nums[]) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(-1, 0);

        int prefixSum = 0;

        int max = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) prefixSum++;
            else prefixSum--;

            if(map.containsKey(prefixSum)) {
                int len = i - map.get(prefixSum);

                max = Math.max(max, len);
            } else {
                map.put(prefixSum, i);
            }
        }

        return max;
    }
}
