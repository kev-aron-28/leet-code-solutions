package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    public List<List<String>> solution(String s) {
        List<List<String>> result = new ArrayList<>();

        dfs(0, s, new ArrayList<>(), result);

        return result;
    }

    private void dfs(int index, String s, List<String> path, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<>(path));

            return;
        }

        for(int end = index; end < s.length(); end++) {
            if(isPalindrome(s, index, end)) {
                path.add(s.substring(index, end + 1));

                dfs(end + 1, s, path, result);

                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}
