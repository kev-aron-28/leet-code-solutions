package review-1.HashMapSet.easy;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public int[] intersection(int nums1[], int nums2[]) {
        Set<Integer> seen = new HashSet<>();

        for(int n : nums1) {
            seen.add(n);
        }

        Set<Integer> matched = new HashSet<>();

        for(int n : nums2){
            if(seen.contains(n)) matched.add(n);
        }

        int result[] = new int[matched.size()];

        int index = 0;

        for(int n : matched) {
            result[index++] = n;
        }

        return result;
    }
}
