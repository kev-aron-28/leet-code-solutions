package common;

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
            int currentLevelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.poll();

                if(node != null) {
                    level.add(node.val);

                    if(node.left != null) queue.add(node.left);
                    if(node.right != null) queue.add(node.right);
                }
            }

            result.add(level);
        }


        return result;
    }
}
