package review-1.SlidingWindow.hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String solution(String s, String t) {
        if(s.length() < t.length()) return "";

        Map<Character, Integer> expected = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(char c : t.toCharArray()) {
            expected.put(c, expected.getOrDefault(c,0 ) + 1);
        }

        int required = expected.size();
        int formed = 0;

        int min = Integer.MAX_VALUE;
        int startOfString = 0;

        int left = 0;

        for(int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            window.put(current, window.getOrDefault(current, 0) + 1);

            if(expected.containsKey(current) && expected.get(current).intValue() == window.get(current)) {
                formed++;
            }

            while (formed == required) { 
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    startOfString = left;
                }

                char leftchar = s.charAt(left);

                window.put(leftchar, window.get(leftchar) - 1);

                if(expected.containsKey(leftchar) && window.get(leftchar) < expected.get(leftchar)) {
                    formed--;
                }

                left++;
            }
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(startOfString, startOfString + min);
    }
}
