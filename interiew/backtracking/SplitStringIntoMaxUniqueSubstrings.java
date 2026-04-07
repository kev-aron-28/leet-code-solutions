package backtracking;

import java.util.HashSet;
import java.util.Set;

public class SplitStringIntoMaxUniqueSubstrings {
    int max = 0;
    public int solution(String s) {
        dfs(0, s, new HashSet<>());
        return max;
    }

    private void dfs(int index, String s, Set<String> used) {
        if(index == s.length()) {
            max = Math.max(used.size(), max);

            return;
        }

        if (used.size() + (s.length() - index) <= max) {
            return;
        }

        for(int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);

            if(!used.contains(sub)) {
                used.add(sub);

                dfs(i + 1, s, used);

                used.remove(sub);
            }
        }
    }
}
