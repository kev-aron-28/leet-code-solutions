package trees;

public class CountGoodNodesInBinaryTree {
    public int solution(TreeNode root) {
        return count(root, root.val);
    }

    public int count(TreeNode node, int maxSoFar) {
        if(node == null) return 0;

        int good = 0;

        if(node.val >= maxSoFar) {
            good = 1;
        }

        int newMax = Math.max(maxSoFar, node.val);

        int left = count(node.left, newMax);
        int right = count(node.right, newMax);

        return good + left + right;
    }
}
