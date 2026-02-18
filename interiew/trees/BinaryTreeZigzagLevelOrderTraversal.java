package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> solution(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null) return result;

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        boolean left = true;

        while(!queue.isEmpty()) {
            int currentLevelSize = queue.size();

            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.poll();

                if(left) {
                    level.add(node.val);
                } else {
                    level.addFirst(node.val);
                }

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);

            }

            result.add(level);
            left = !left;
        }

        return result;
    }
}
