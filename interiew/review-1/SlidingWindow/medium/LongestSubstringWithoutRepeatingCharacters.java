package review-1.SlidingWindow.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int solution(String s) {
        Set<Character> set = new HashSet<>();

        int max = 0;
        int left = 0;
        int right = 0;

        while(right < s.length()) {
            char c = s.charAt(right);

            while (set.contains(c)) { 
               set.remove(s.charAt(left));
               
               left++;
            }

            set.add(c);

            right++;

            max = Math.max(max, right - left);
            
        }

        return max;
    }
}
