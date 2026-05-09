package trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    Map<Integer,Integer> map = new HashMap<>();
    int nextHead = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int preorder[], int left, int right) {
        if(left > right) return null;

        int head = preorder[nextHead++];

        TreeNode node = new TreeNode(head);

        int mid = map.get(head);

        node.left = build(preorder, left, mid - 1);
        node.right = build(preorder, mid + 1, right);

        return node;
    }
}
