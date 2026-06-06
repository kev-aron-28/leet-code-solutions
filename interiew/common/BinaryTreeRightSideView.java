package common;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import trees.TreeNode;

public class BinaryTreeRightSideView {
    public List<Integer> solution(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) { 
            int size = queue.size();


            for(int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if(i == size - 1) {
                    result.add(current.val);
                }

                if(current.left != null) queue.add(current.left);

                if(current.right != null) queue.add(current.right);
            }
        }

        return result;
    }
}
