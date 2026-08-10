package marathons.trees-1;

import java.util.HashMap;
import java.util.Map;
import trees.TreeNode;


public class ConstructBinaryTreefromInorderandPostorderTraversal {
    int parent = 0;
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode solution(int[] inorder, int[] postorder) {
        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        parent = postorder.length - 1;

        return build(inorder, postorder, 0, inorder.length - 1);
    }

    public TreeNode build(int inorder[], int postorder[], int left, int right) {
        int rootValue = postorder[parent--];

        TreeNode root = new TreeNode(rootValue);

        int rootIndex = inorderMap.get(rootValue);

        root.right = build(inorder, postorder, rootIndex + 1, right);

        root.left = build(inorder, postorder, left, rootIndex - 1);

        return root;
    }
}
