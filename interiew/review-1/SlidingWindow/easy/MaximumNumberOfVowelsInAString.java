package review-1.SlidingWindow.easy;

public class MaximumNumberOfVowelsInAString {
    public int maxVowels(String s, int k) {
        int vowelsInWindow = 0;

        int right;
        for(right = 0; right < k; right++) {
            char c = s.charAt(right);
            if(isVowel(c)) vowelsInWindow++;
        }

        int max = vowelsInWindow;

        while(right < s.length()) {
            char removed = s.charAt(right - k);

            if(isVowel(removed)) vowelsInWindow--;
            
            char rightChar = s.charAt(right);
            
            if(isVowel(rightChar)) vowelsInWindow++;
            
            max = Math.max(max, vowelsInWindow);
            right++;
        }

        return max;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
