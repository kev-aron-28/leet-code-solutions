package daily;

import java.util.HashSet;
import java.util.Set;

public class MinimumDeletionstoMakeCharacterFrequenciesUnique {
    public int solution(String s) {
        int freq[] = new int[26];

        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        Set<Integer> set = new HashSet<>();
        int count = 0;
        for(int f : freq) {
            while (f > 0 && set.contains(f)) { 
                f--;
                count++;
            }

            if(f > 0) set.add(f);
        }

        return count;
    }
}
