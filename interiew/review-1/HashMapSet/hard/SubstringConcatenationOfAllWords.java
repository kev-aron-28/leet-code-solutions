package review-1.HashMapSet.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringConcatenationOfAllWords {
    public List<Integer> solution(String s, String words[]) {
        List<Integer> result = new ArrayList<>();

        if(words == null || s == null || words.length == 0) return result;

        int wordSize = words[0].length();
        int fullSize = wordSize * words.length;
        int requiredWords = words.length;

        if(s.length() < fullSize) return result;

        Map<String, Integer> required = new HashMap();

        for(String word : words) {
            required.put(word, required.getOrDefault(word, 0) + 1);
        }

        for(int offset = 0; offset < wordSize; offset++) {
            int left = offset;

            Map<String, Integer> window = new HashMap<>();
            int found = 0;

            for(int right = offset; right + wordSize <= s.length(); right += wordSize) {
                String word = s.substring(right, right + wordSize);

                if(!required.containsKey(word)) {
                    window.clear();
                    found = 0;
                    left = right + wordSize;
                    continue;
                }

                window.put(word, window.getOrDefault(word, 0) + 1);

                found++;

                while (window.get(word) > required.get(word)) { 
                    String leftWord = s.substring(left, left + wordSize);

                    window.put(leftWord, window.get(leftWord) - 1);

                    left += wordSize;

                    found--;
                }


                if(found == requiredWords) {
                    result.add(left);

                    String leftWord = s.substring(left, left + wordSize);

                    window.put(leftWord, window.get(leftWord) - 1);

                    left += wordSize;
                    found--;
                }
            }
        }

        return result;
    }
}
