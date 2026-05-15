package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> solution(String strs[]) {        
        Map<String, List<String>> map = new HashMap();

        for(String s : strs) {
            char arrChar[] = s.toCharArray();

            Arrays.sort(arrChar);

            String key = new String(arrChar);

            map.putIfAbsent(key, new ArrayList<>());

            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
