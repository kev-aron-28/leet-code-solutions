
import java.util.HashMap;
import java.util.Map;

public class SetMismatch {
    public int[] solution(int nums[]) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int n = nums.length;

        int duplicate = 0;
        int missing = 0;

        for(int i = 1; i <= n; i++) {
            if (!map.containsKey(i)) {
                missing = i;
            } else if (map.get(i) > 1){
                duplicate = i;
            }
        }

        return new int[] {duplicate, missing};
    }
}
