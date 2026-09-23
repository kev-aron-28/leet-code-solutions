package stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuildAnArrayWithStackOperations {

    public List<String> solution(int target[], int n) {
        Set<Integer> set = new HashSet<>();

        for (int num : target) {
            set.add(num);
        }

        List<String> result = new ArrayList<>();

        int built = 0;

        for (int i = 1; i <= n; i++) {
            if (built == target.length) {
                return result;
            }

            boolean needed = set.contains(i);

            result.add("Push");

            if (needed) {
                built++;
            } else {
                result.add("Pop");
            }
        }

        return result;
    }
}
