package review-1.SlidingWindow.medium;

public class LongestRepeatingCharacterReplacement {
    public int solution(String s, int k) {
        int window[] = new int[26];

        int maxInRepeatedInWindow;
        int left = 0;
        
        int max = 0;

        for(int right = 0; right < s.length(); right++){
            window[s.charAt(right) - 'A']++;

            maxInRepeatedInWindow = Math.max(window[s.charAt(right) - 'A'], max);

            while ((right - left + 1) - maxInRepeatedInWindow > k) { 
                window[s.charAt(left) - 'A']--;
                
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
