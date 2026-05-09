package trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    int nextHead = 0;

    Map<Integer,Integer> map = new HashMap<>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        nextHead = postorder.length - 1;
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int postorder[], int left, int right) {
        if(left > right) return null;

        int head = postorder[nextHead--];

        TreeNode node = new TreeNode(head);

        int mid = map.get(head);

        node.right = build(postorder, mid + 1, right);
        node.left = build(postorder, left, mid - 1);

        return node;
    }
}
