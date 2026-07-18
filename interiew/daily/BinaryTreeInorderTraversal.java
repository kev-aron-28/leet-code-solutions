package daily;

import java.util.ArrayList;
import java.util.List;

import trees.TreeNode;

public class BinaryTreeInorderTraversal {
    public List<Integer> solution(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        inorder(root, result);

        return result;
    } 

    private void inorder(TreeNode node, List<Integer> result) {
        if(node == null) return;

        inorder(node.left, result);

        result.add(node.val);

        inorder(node.right, result);
    }
}
