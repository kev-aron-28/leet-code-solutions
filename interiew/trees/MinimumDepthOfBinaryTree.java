package trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {

        if(root == null) return 0;


        if(root.left == null && root.right == null) return 1;

        if(root.right == null) {
            return 1 + minDepth(root.left);
        }

        if(root.left == null) {
            return 1 + minDepth(root.right);
        }

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    public int minDepth2(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        int minDepth = 1;

        while (!queue.isEmpty()) { 
            int currentLevelSize = queue.size();

            for(int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.poll();

                if(node.left == null && node.right == null) return minDepth;
                
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }

            minDepth++;
        }

        return minDepth;
    }
}