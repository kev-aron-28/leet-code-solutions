package review-3.trees.dfs;

import java.util.ArrayDeque;
import java.util.Queue;

import trees.TreeNode;


public class MaximumLevelSum {
    public int solution(TreeNode root) {
        if(root == null) return 0;
        
        int maxLevel = 1;

        int maxSum = Integer.MIN_VALUE;

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);

        int level = 0;
        while(!queue.isEmpty()) {
            level++;
            int size = queue.size();
            int sum = 0;

            for(int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if(current != null) {
                    sum += current.val;

                    if(current.left != null) queue.offer(current.left);
                    if(current.right != null) queue.offer(current.right);
                }
            }

            if(sum > maxSum) {
                maxSum = sum;
                maxLevel = level;
            }
        }

        return maxLevel;
    }
}
