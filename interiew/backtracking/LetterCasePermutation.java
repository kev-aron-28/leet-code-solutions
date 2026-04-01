package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public List<String> solution(String s) {
        List<String> result = new ArrayList<>();
        

        dfs(0, s, new StringBuilder(), result);

        return result;
    }

    private void dfs(int index, String s, StringBuilder path, List<String> result) {
        if (index == s.length()) {
            result.add(path.toString());

            return;
        }

        char c = s.charAt(index);

        if (Character.isDigit(c)) {
            path.append(c);

            dfs(index + 1, s, path, result);

            path.deleteCharAt(path.length() - 1);
        } else {
            path.append(Character.toLowerCase(c));

            dfs(index + 1, s, path, result);

            path.deleteCharAt(path.length() - 1);

            path.append(Character.toUpperCase(c));

            dfs(index + 1, s, path, result);

            path.deleteCharAt(path.length() - 1);
            
        }
    }
}
