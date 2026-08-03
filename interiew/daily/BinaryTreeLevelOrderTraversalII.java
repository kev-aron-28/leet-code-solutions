package daily;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import trees.TreeNode;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> result(TreeNode root) {
        if(root == null) return List.of();

        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);

        List<List<Integer>> result = new ArrayList<>();

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> current = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if(node != null) {
                    current.add(node.val);
                    if(node.left != null) queue.offer(node.left);
                    if(node.right != null) queue.offer(node.right);
                }
            }

            result.addFirst(current);
        }

        return result;
    }
}
