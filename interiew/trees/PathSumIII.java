package trees;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {
    public int solution(TreeNode node, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);

        return dfs(node, targetSum, map, 0);
    }

    private int dfs(TreeNode node, int targetSum, Map<Long, Integer> map, long prefixSum) {
        if(node == null) return 0;

        prefixSum += node.val;

        int count = map.getOrDefault(prefixSum - targetSum, 0);

        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);

        count += dfs(node.left, targetSum, map, prefixSum);
        count += dfs(node.right, targetSum, map, prefixSum);

        map.put(prefixSum, map.get(prefixSum) - 1);

        return count;
    }
}
