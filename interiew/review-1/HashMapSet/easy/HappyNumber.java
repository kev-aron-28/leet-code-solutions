package review-1.HashMapSet.easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean solution(int n) {
        Set<Integer> seen = new HashSet<>();

        while(n != 1) {
            if(seen.contains(n)) return false;

            seen.add(n);

            int current = n;
            int sum = 0;

            while (current > 0) { 
                int digit = current % 10;
                sum += digit * digit;
                current /= 10;
            }

            n = sum;
        } 


        return true;
    }  
}
