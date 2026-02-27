package trees;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {
    public int solution(TreeNode node, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        return dfs(node, targetSum, map, 0);
    }

    private int dfs(TreeNode node, int targetSum, Map<Integer, Integer> map, int prefixSum) {
        if(node == null) return 0;

        prefixSum += node.val;


        int count = map.getOrDefault(prefixSum - targetSum, 0);

        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);

        

        return 0;
    }
}
