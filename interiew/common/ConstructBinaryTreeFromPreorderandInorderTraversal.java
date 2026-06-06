package common;

import java.util.HashMap;
import java.util.Map;

import trees.TreeNode;

public class ConstructBinaryTreeFromPreorderandInorderTraversal {

    private int preorderIndex = 0;

    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode solution(int preorder[], int inorder[]) {
        
        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1);
    } 

    private TreeNode build(int preOrder[], int left, int right) {
        if(left > right) return null;

        int rootValue = preOrder[preorderIndex++];

        TreeNode root = new TreeNode(rootValue);

        int rootIndex = inorderMap.get(rootValue);

        root.left = build(preOrder, left, rootIndex - 1);

        root.right = build(preOrder, rootIndex + 1, right);

        return root;
    }
}
