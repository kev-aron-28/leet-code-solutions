
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChars3 {
  
  public int lengthOfLongestSubstring(String s) {
    int maxSoFar = 0;
    Set<Character> set = new HashSet<>();  
    
    int counting = 0;

    for (int i = 0; i < s.length(); i++) {
      char current = s.charAt(i);

      if(!set.contains(current)) {
        set.add(current);
        counting++;
        maxSoFar = Math.max(counting, maxSoFar);
      } else {
        counting = 0;
      }
    }

    return maxSoFar;
  }

  public static void main(String[] args) {
      
  }
}
