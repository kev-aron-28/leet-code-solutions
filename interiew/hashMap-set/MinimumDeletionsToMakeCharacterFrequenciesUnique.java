
import java.util.HashSet;
import java.util.Set;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    public int minDeletions(String s) {
        int freq[] = new int[26];

        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        Set<Integer> usedFreq = new HashSet<>();

        int count = 0;
        for(int frequency : freq) {

            while (frequency > 0 && usedFreq.contains(frequency) ) { 
                frequency--;
                count++;
            }

            if(frequency > 0) usedFreq.add(frequency);
        }

        return count;
    }
}
