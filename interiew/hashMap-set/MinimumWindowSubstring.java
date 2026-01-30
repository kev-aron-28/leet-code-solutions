
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public int solution(String s, String t) {

        Map<Character, Integer> freq = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(char current : t.toCharArray()) {
            freq.put(current, freq.getOrDefault(current, 0) + 1);
        }

        int required = freq.size();

        int foundUntilNow = 0;

        int min = Integer.MAX_VALUE;

        int left = 0;

        for(int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
            
            if(freq.containsKey(rightChar) && freq.get(rightChar).intValue() == window.get(rightChar).intValue()) {
                foundUntilNow++;
            }

            while(foundUntilNow == required) {
                min = Math.min(min, right - left + 1);

                char leftChar = s.charAt(left);
                
                window.put(leftChar, window.get(leftChar) - 1);
                
                if (freq.containsKey(leftChar) && window.get(leftChar) < freq.get(leftChar)) foundUntilNow--;
                
                left++;
            }

        }
        
        return min;
    }
    
    public static void main(String[] args) {
        
    }
}
