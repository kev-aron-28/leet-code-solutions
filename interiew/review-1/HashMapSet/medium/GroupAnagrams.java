package review-1.HashMapSet.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String> solution(String strs[]) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            char keyArr[] = str.toCharArray();

            Arrays.sort(keyArr);

            String key = new String(keyArr);

            map.putIfAbsent(key, new ArrayList<>());

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
