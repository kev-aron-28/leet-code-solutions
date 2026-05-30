package common;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChars {
    public int solution(String s) {
        Set<Character> set = new HashSet<>();
        
        int left = 0;
        int right = 0;
        int max = 0;

        while (right < s.length()) { 
            char current = s.charAt(right);

            while (set.contains(current)) { 
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            max = Math.max(max, right - left + 1);

            right++;
        }


        return max;
    }
}
