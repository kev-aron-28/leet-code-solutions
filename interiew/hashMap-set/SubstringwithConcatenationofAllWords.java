import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringwithConcatenationofAllWords {
    
    public static List<Integer> solution(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if(s == null || words.length == 0 || words == null) return result;

        int wordLen = words[0].length();

        int totalLen = wordLen * words.length;

        if(totalLen > s.length()) return result;

        Map<String, Integer> wordCount = new HashMap<>();

        for(String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for(int offset = 0; offset < wordLen; offset++) {
            HashMap<String, Integer> windowCount = new HashMap<>();

            int left = offset;
            int foundWords = 0;

            for(int right = offset; right + wordLen <= s.length(); right += wordLen) {
                String word = s.substring(right, right + wordLen);

                if(wordCount.containsKey(word)) {
                    windowCount.put(word, windowCount.getOrDefault(word, 0) + 1);
                    foundWords++;

                    while(windowCount.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);

                        windowCount.put(leftWord, windowCount.get(leftWord) - 1);
                        
                        foundWords--;

                        left += wordLen;
                    }

                    if(foundWords == words.length) result.add(left);
                } else {
                    foundWords = 0;
                    windowCount.clear();
                    left = wordLen + right;
                }
            }
        }

        return result;
    }
    
    public static void main(String[] args) {
        String words[] = { "ab","ba","ba" };

        String s = "ababaab";

        for(int i : solution(s, words)) {
            System.out.println(i);
        } 
    }
}
