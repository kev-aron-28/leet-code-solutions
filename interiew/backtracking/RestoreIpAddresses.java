package backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public List<String> solution(String s) {
        List<String> result = new ArrayList<>();

        dfs(0, s, new ArrayList<>(), result);

        return result;
    }

    public void dfs(int index, String s, List<String> path, List<String> result) {
        
        if(path.size() == 4) {
            if(index == s.length()) {
                result.add(String.join(".", path));
            }


            return;
        }

        for(int i = 1; i <= 3; i++) {
            if(index + i > s.length()) break;

            String part = s.substring(index, index + i);
            
            if(!isValid(part)) continue;

            path.add(part);

            dfs(index + i, s, path, result);

            path.remove(path.size() - 1);
        }
    }

    private boolean isValid(String s) {
        if(s.length() > 1 && s.startsWith("0")) return false;

        int num =  Integer.parseInt(s);

        return num <= 255;
    }
}
