package daily;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public int[] solution(int nums1[], int nums2[]) {
        Set<Integer> seen = new HashSet<>();

        for(int n : nums1) seen.add(n);

        Set<Integer> intersection = new HashSet<>();

        for(int n : nums2) {
            if(seen.contains(n)) intersection.add(n);
        }

        int result[] = new int[intersection.size()];

        int index = 0;

        for(int n : intersection) {
            result[index++] = n;
        }

        return result;
    } 
}
