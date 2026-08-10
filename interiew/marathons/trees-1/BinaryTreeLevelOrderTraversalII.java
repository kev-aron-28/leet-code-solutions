package marathons.trees-1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import trees.TreeNode;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> solution(TreeNode root) {
        if(root == null) return List.of();

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) { 
            int level = queue.size();
            List<Integer> current = new ArrayList<>();

            for(int i = 0; i < level; i++) {
                TreeNode node = queue.poll();

                if(node != null) {
                    result.add(current.val);

                    if(node.left != null) queue.add(node.left);
                    if(node.right != null) queue.add(node.right);
                }
            }

            result.addFirst(current);
        }

        return result;
    }
}
