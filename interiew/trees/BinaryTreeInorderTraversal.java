package trees;
//

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



public class BinaryTreeInorderTraversal {
    public void inorder(TreeNode node, List<Integer> result) {
        if(node == null) return;

        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }

    public List<Integer> inorder(TreeNode root) {

        Stack<TreeNode> pending = new Stack<>();

        TreeNode curr = root;

        List<Integer> result = new ArrayList<>();

        while (curr != null || !pending.isEmpty()) { 
            
            while(curr != null) {
                pending.push(curr);
                curr = curr.left;
            }

            curr = pending.pop();

            result.add(curr.val);

            curr = curr.right;
        }


        return result;
    }
}
