
package marathons.backtracking-1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LetterCombinationOfAPhoneNumber {
    Map<Character, String> map = new HashMap<>();
    public List<String> solution(String digits) {
        List<String> result = new ArrayList<>();


        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "abc");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        combinations(digits, 0, new StringBuilder(), result);

        return result;
    }

    public void combinations(String digits, int i, StringBuilder path, List<String> result) {
        if(i == digits.length()) {
            result.add(path.toString());
            return;
        }


        String letters = map.get(digits.charAt(i));

        for(char c : letters.toCharArray()) {
            path.append(c);

            combinations(digits, i + 1, path, result);
            
            path.deleteCharAt(path.length() - 1);
        }
        
    }

}
