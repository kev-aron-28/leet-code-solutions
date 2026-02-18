package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return List.of();

        List<List<Integer>> result = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();
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

            result.addFirst(level);
        }

        return result;
    } 
}
