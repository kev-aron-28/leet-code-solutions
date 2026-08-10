package marathons.trees

import trees.TreeNode;

-1;

public class SmallestStringFromLeaf {
    String smallest = null;

    public String solution(TreeNode root) {
        preorder(root, "");
        return smallest;
    }

    public void preorder(TreeNode node, String path) {
        if(node == null) return;

        char current = node.val + 'a';

        path = current + path;

        if(node.left == null || node.right == null) {
            if(smallest == null | path.compareTo(smallest) < 0) smallest = path;
        } 

        preorder(node.left, path);
        preorder(node.right, path);
    }
}
