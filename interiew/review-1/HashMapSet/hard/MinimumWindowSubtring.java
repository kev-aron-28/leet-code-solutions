package review-1.HashMapSet.hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubtring {
    public String solution(String s, String t) {
        if(s.length() < t.length()) return "";

        Map<Character, Integer> expected = new HashMap<>();
        Map<Character, Integer> currentWindow = new HashMap<>();

        for(char c : t.toCharArray()) {
            expected.put(c, expected.getOrDefault(c,0) + 1);
        }

        int required = expected.size();
        int currentFormed = 0;

        int left = 0;
        int right = 0;

        int min = Integer.MAX_VALUE;
        int startString = 0;

        while (right < s.length()) { 
            char currentChar = s.charAt(right);
            currentWindow.put(currentChar, currentWindow.getOrDefault(currentChar, 0) + 1);

            if(expected.containsKey(currentChar) && currentWindow.get(currentChar).intValue() == expected.get(currentChar).intValue()) {
                currentFormed++;
            }

            while(currentFormed == required) {
                if (min > right - left + 1) {
                    startString = left;
                    min = right - left + 1;
                }

                char leftChar = s.charAt(left);

                currentWindow.put(leftChar, currentWindow.get(leftChar) - 1);

                if(expected.containsKey(leftChar) && currentWindow.get(leftChar) < expected.get(leftChar)) {
                    currentFormed--;
                }

                left++;
            }

            right++;
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(startString, startString + min);
    }
}
