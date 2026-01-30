public class ReplaceSubstringWithBalancedString {
    public int solution(String s) {
        int count[] = new int[128];

        int requiredFreq = s.length() / 4;

        int left = 0;

        int min = s.length();

        for(char c : s.toCharArray()) {
            count[c]++;
        }

        if(
            count['W'] == requiredFreq &&
            count['Q'] == requiredFreq &&
            count['R'] == requiredFreq &&
            count['E'] == requiredFreq
        ) return 0;


        // We need to find the smalles window that contains all the correct characters < or equal. as the rest
        // we can replace it         
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            count[rightChar]--;

            while(
                left < s.length() &&
                count['W'] <= requiredFreq &&
                count['Q'] <= requiredFreq &&
                count['R'] <= requiredFreq &&
                count['E'] <= requiredFreq
            ) {
                min = Math.min(min, right - left + 1);

                char leftChar = s.charAt(left);

                count[leftChar]++;

                left++;
            }
        }

        return min;
    }
    
    public static void main(String[] args) {
        
    }
}
