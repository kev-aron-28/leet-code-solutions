
import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubArraySumEqualsK {
    public int solution(int nums[], int k) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int prefixSum = 0;
        
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if(map.containsKey(prefixSum - k)) {
                max = Math.max(max, i - map.get(prefixSum - k));
            } else {
                map.put(prefixSum, i);
            }
        }

        return 0;
    }
}
