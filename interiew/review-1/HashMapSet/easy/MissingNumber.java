package review-1.HashMapSet.easy;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {
    public int solution(int nums[]) {
        Set<Integer> seen = new HashSet<>();

        for(int n : nums) {
            seen.add(n);
        }

        for(int i = 0; i <= nums.length; i++) {
            if(!seen.contains(i)) return i;
        }

        return -1;
    }

    public int solution1(int nums[]) {
        int n = nums.length;

        int expected = n * (n + 1) / 2;

        int actual = 0;

        for(int num : nums) {
            actual += num;
        }

        return expected - actual;
    }
}
