package trees;

public class SmallestStringFromLeaf {
    
     String smallest = null;
    public String smallest(TreeNode root) {
        preOrder(root, "");
        return smallest;
    }

    public  void preOrder(TreeNode node, String path) {
        if(node == null) return;

        char currentChar = (char)(node.val + 'a');
        
        path = currentChar + path;
        
        if(node.left == null && node.right == null) {
            if(smallest.compareTo(path) < 0 || smallest == null) smallest = path;
        }
        
        preOrder(node.left, path);
        preOrder(node.right, path);
    }
}
