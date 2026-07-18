package daily;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import trees.TreeNode;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> solution(TreeNode root) {
        if(root == null) return List.of();

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) { 
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                if(current != null) {
                    level.add(current.val);
                    if(current.left != null) queue.add(current.left);
                    if(current.right != null) queue.add(current.right);
                }
            }

            result.add(level);
        }

        return result;
    } 
}
