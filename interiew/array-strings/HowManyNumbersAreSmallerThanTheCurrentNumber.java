
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HowManyNumbersAreSmallerThanTheCurrentNumber {
    public int[] solution(int nums[]) {
        int sorted[] = nums.clone();
        
        Arrays.sort(sorted);
        
        int n = nums.length;
        int result[] = new int[n];

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            map.putIfAbsent(sorted[i], i);
        }

        for(int i = 0; i < n; i++) {
            result[i] = map.get(i);
        }

        return result;
    }
}
