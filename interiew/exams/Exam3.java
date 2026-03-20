import trees.TreeNode;

public class Exam3 {
    public int binaryTreeMaximumPathSum(TreeNode root) {
        int res[] = { Integer.MIN_VALUE };
        
        return res[0];
    }    

    private int binaryTreeMaximumPathSumHelper(TreeNode node, int maxSum[]) {
        if(node == null) return 0;

        int left = binaryTreeMaximumPathSumHelper(node.left, maxSum);
        int right = binaryTreeMaximumPathSumHelper(node.right, maxSum);

        maxSum[0] = Math.max(left + right + node.val, maxSum[0]);

        return node.val + Math.max(left, right);
    }
}
