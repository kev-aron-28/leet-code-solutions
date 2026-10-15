package review-3.trees.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import trees.TreeNode;


public class AverageOfLevels {
    public List<Double> solution(TreeNode root) {
        if(root == null) return List.of();

        List<Double> result = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            
            double sum = 0.0;

            for(int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if(current != null) {
                    sum += (double) current.val;

                    if(current.left != null) queue.offer(current.left);
                    if(current.right != null) queue.offer(current.right);
                }
            }

            result.add(sum / (double) size);
        }

        return result;
    }
}
