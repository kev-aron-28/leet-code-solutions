
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChars3 {
  
  public int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<>();  
    int maxSoFar = 0;
    int startWindow = 0, endWindow = 0;

    while (endWindow < s.length()) {
      char currentLetter = s.charAt(endWindow);

      while (set.contains(currentLetter)) {
        set.remove(s.charAt(startWindow));
        startWindow++;
      }

      set.add(currentLetter);
      endWindow++;

      maxSoFar = Math.max(maxSoFar, endWindow - startWindow);
    }
    
    return maxSoFar;
  }

  public static void main(String[] args) {
      
  }
}
