package daily;

import java.util.HashSet;
import java.util.Set;

public class SplitStringIntoMaxUniqueSubstrings {
    int max = 0;
    public int solution(String s) {
        Set<String> used = new HashSet<>();

        backtrack(s, max, used);

        return max;
    }

    private void backtrack(String s, int start, Set<String> used) {
        if (start == s.length()) {
            max = Math.max(max, used.size());

            return;
        }

        for(int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);

            if (used.contains(substring)) {
                continue;
            }

            used.add(substring);

            backtrack(s, end, used);

            used.remove(substring);
        }
    }
}
