
import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
    public List<Integer> solution(String s, String p) {

        if(s.length() < p.length()) return List.of();

        int freq1[] = new int[26];
        int windowFreq[] = new int[26];

        List<Integer> result = new ArrayList<>(); 

        int right;
        int left = 0;

        for(right = 0; right < p.length(); right++) {
            freq1[p.charAt(right) - 'a']++;
            windowFreq[s.charAt(right) -'a']++;
        }

        if(matches(freq1, windowFreq)) result.add(0);

        while(right < s.length()) {
            char rightChar = s.charAt(right);
            char leftChar = s.charAt(left);
            windowFreq[rightChar - 'a']++;
            windowFreq[leftChar - 'a']--;

            if(matches(freq1, windowFreq)) result.add(left + 1);
            right++;
            left++;
        }

        return result;
    }

    public boolean matches(int freq1[], int freq2[]) {
        for(int i = 0; i < freq1.length; i++) {
            if(freq1[i] != freq2[i]) return false;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        
    }
}
