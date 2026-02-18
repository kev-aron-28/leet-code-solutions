package trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaximumDepthofBinaryTree {
    public int solution(TreeNode node) {
        if(node == null) return 0;

        int left = solution(node.left);
        int right = solution(node.right);

        return 1 + Math.max(left, right);
    }

    public int solution2(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        int depth = 0;

        while (!queue.isEmpty()) { 
            int currentLevelSize = queue.size();

            depth++;

            for(int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.poll();

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }

        }

        return depth;
    }

}
