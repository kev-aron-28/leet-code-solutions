package common;

public class LongestRepeatingCharacterReplacement {
    public int solution(String s, int k) {
        int count[] = new int[26];

        int left = 0;
        
        int result = 0;
        
        int maxFreqCharInWindow = 0;

        for(int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;

            maxFreqCharInWindow = Math.max(maxFreqCharInWindow, count[s.charAt(right) - 'A']);

            while ((right - left + 1) - maxFreqCharInWindow > k) { 
                count[s.charAt(left) - 'A']--;

                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
