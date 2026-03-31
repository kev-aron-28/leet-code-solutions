package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public List<String>solution(String digits) {
        List<String> result = new ArrayList<>();

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    
        
        dfs(digits, 0, map, result, new StringBuilder());

        return result;
    }

    private void dfs(String digits, int index, Map<Character, String> map, List<String> result, StringBuilder current) {
        if (index == digits.length()) {
            result.add(current.toString());

            return;
        }

        String letters = map.get(digits.charAt(index));

        for(char c : letters.toCharArray()) {
            current.append(c);

            dfs(digits, index + 1, map, result, current);

            current.deleteCharAt(current.length() - 1);
        }
    }
}
