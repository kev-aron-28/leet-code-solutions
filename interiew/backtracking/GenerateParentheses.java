package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> solution (int n) {
        List<String> result = new ArrayList<>();

        dfs(n, 0, 0, new StringBuilder(), result);

        return result;
    } 

    private void dfs(int n, int open, int close, StringBuilder path, List<String> result) {
        if(path.length() == n * 2) {
            result.add(path.toString());

            return;
        }

        if (open < n) {
            path.append("(");
            dfs(n, open + 1, close, path, result);
            path.deleteCharAt(path.length() - 1);
        }

        if (close < open) {
            path.append("}");
            dfs(n, open, close + 1, path, result);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
