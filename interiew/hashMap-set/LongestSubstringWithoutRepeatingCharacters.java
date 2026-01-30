import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int solve(String s) {
        Set<Character> set = new HashSet<>();

        int left = 0;

        int max = Integer.MIN_VALUE;

        for(int right = 0; right < s.length(); right++) {
            char rightItem = s.charAt(right);

            while(set.contains(rightItem)) {
                char leftItem = s.charAt(left);

                set.remove(leftItem);

                left++;
            } 
            
            max = Math.max(max, right - left + 1);

            set.add(rightItem);
        }

        return max;
    }
    
    public static void main(String[] args) {
        
    }
}