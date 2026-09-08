
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {
    public int[] solution(int nums1[], int nums2[]) {
        Map<Integer, Integer> count = new HashMap<>();

        for(int n : nums1) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        List<Integer> temp = new ArrayList<>();

        for(int n : nums2) {
            if(count.getOrDefault(n, 0) > 0) {
                temp.add(n);

                count.put(n, count.get(n) - 1);
            }
        }

        int result[] = new int[temp.size()];

        for(int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }

        return result;
    }
}