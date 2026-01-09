import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int longest(String chars) {
        int max = 0;
        Set<Character> set = new HashSet<>();
        int left = 0;

        for(int right = 0; right < chars.length(); right++) {
            while(set.contains(chars.charAt(right))) {
                set.remove(chars.charAt(left));

                left++;
            }

            set.add(chars.charAt(right));

            max = Math.max(right - left + 1, max);
        }

        return max;
    }
    
    public static void main(String[] args) {
        
    }
}
