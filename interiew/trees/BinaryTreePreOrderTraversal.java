package trees;

import java.util.List;

public class BinaryTreePreOrderTraversal {
    public void preOrder(TreeNode node, List<Integer> result) {
        if(node == null) return;

        result.add(node.val);
        preOrder(node.left, result);
        preOrder(node.right, result);
    }
}
