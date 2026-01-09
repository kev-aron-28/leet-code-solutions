import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        
        int left = 0;
        int maxFrequency = 0;
        int maxLen = 0;

        for(int rigth = 0; rigth < s.length(); rigth++) {
            char c = s.charAt(rigth);
            count.put(c, count.getOrDefault(c, 0) + 1);

            maxFrequency = Math.max(maxFrequency, count.get(c));

            while((rigth - left + 1) - maxFrequency > k) {
                count.put(s.charAt(left), count.get(s.charAt(left)) - 1);
                left++;
            }

            maxLen = Math.max(maxLen, rigth - left + 1);
        }
        


        return maxLen;
    } 
    
    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA", 3));
    }
}
