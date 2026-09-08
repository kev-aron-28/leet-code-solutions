package daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {
    public List<Integer> solution(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int pCount[] = new int[26];

        int windowCount[] = new int[26];

        for(char a : p.toCharArray()) {
            pCount[a - 'a']++;
        }

        int left = 0;

        for(int right = 0; right < s.length(); right++) {
            windowCount[s.charAt(right) - 'a']++;

            if (right - left + 1 > p.length()) {
                windowCount[s.charAt(left) - 'a']--;
                
                left++;
            }

            if(Arrays.equals(pCount, windowCount)) {
                result.add(right);
            }
        }

        return result;
    }
}
