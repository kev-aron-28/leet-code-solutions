package daily;

import trees.TreeNode;

public class SmallestStringStartingFromLeaf {
    String smallest = null;
    public String solution(TreeNode root) {
        preorder(root, "");
        return smallest;
    }

    private void preorder(TreeNode node, String path) {
        if(node == null) return;

        char current = (char)(node.val + 'a');
        
        path = current + path;

        if(node.left == null && node.right == null) {
            if(smallest == null || path.compareTo(smallest) < 0) smallest = path;
        }

        preorder(node.left, path);
        preorder(node.right, path);
    }
}
