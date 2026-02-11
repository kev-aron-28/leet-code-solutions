
import java.util.HashMap;

public class SubarraySumEqualsK {
    public int solution(int nums[], int k) {

       HashMap<Integer, Integer> freq = new HashMap<>();

       freq.put(0, 1);

       int prefixSum = 0;
        
        int count = 0;

        for(int i : nums) {
            prefixSum += i;

            if(freq.containsKey(prefixSum - k)) {
                count += freq.get(prefixSum - k);
            }

            freq.put(prefixSum, freq.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
