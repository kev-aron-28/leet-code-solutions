
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
    
    public int solution (String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();

        int left = 0;

        int max = 0;

        for(int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            freq.put(rightChar, freq.getOrDefault(rightChar, 0) + 1);

            while(freq.size() > k) {
                char leftChar = s.charAt(left);

                freq.put(leftChar, freq.get(leftChar) - 1);
                
                if(freq.get(leftChar) == 0) freq.remove(leftChar);
                
                left++;
            }

            max = Math.max(max, right - left + 1);
        }


        return max;
    }
    
    public static void main(String[] args) {
        
    }
}
