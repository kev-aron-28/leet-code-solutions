
import java.util.Arrays;

public class SubstringsOfSizeKWithKDistinctCharacters {
    public int solution(String s, int k) {
        int window[] = new int[26];
        Arrays.fill(window, 0);
        int right;
        int left = 0;

        int result = 0;

        for(right = 0; right < k; right++) {
            char rightChar = s.charAt(right);
            window[rightChar - 'a']++;
        }

        if(isValid(window, k)) result++;

        while(right < s.length()) {
            char rightChar = s.charAt(right);
            char leftChar = s.charAt(left);
            window[rightChar - 'a']++;
            window[leftChar - 'a']--;

            if(isValid(window, k)) result++;

            right++;
            left++;
        }

        return result;
    }

    public boolean isValid (int window[], int k){
        int distinct = 0;

        for(int i = 0; i < window.length; i++) {
            if(window[k] > 0) distinct++;
            if(distinct > k) return false;
        }

        return distinct == k;
    }
    
    public static void main(String[] args) {

    }
}
