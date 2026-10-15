package review-3.trees.dfs;
import java.util.*;

import trees.TreeNode;


public class RightSideView {
    public List<List<Integer>> solution(TreeNode root) {
        if(root == null) return List.of();

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if(i == size - 1) {
                    level.add(current.val);
                }

                queue.add(current.left);
                queue.add(current.right);
            } 

            result.add(level);
        }

        return result;
    }
}
