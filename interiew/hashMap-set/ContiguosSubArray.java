
import java.util.HashMap;

public class ContiguosSubArray {
    public int solution(int nums[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int prefixSum = 0;

        int max = 0;

        for(int i = 0; i < nums.length; i++) {
            prefixSum += ((nums[i] == 0) ? -1 : +1);

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
