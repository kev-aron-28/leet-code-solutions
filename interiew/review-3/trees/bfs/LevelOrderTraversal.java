package review-3.trees.bfs;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

import trees.TreeNode;

import java.util.ArrayDeque;

public class LevelOrderTraversal {
    public List<List<Integer>> solution(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();

            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                if(current != null) {
                    level.add(current.val);
                    if(current.left != null) queue.offer(current.left);
                    if(current.right != null) queue.offer(current.right);
                }
            }

            result.add(level);
        }
    
        return result;
    }


}
