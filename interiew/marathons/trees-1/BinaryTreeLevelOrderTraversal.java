package marathons.trees-1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import trees.TreeNode;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> solution(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) { 
            int level = queue.size();
            List<Integer> current = new ArrayList<>();

            for(int i = 0; i < level; i++) {
                TreeNode node = queue.poll();

                if(node != null) {
                    current.add(node.val);
                    if(node.left != null) queue.add(node.left);
                    if(node.right != null) queue.add(node.right);

                }
            }

            result.add(current);
        }

        return result;
    } 
}
