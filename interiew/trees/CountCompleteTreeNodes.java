package trees;

public class CountCompleteTreeNodes {
    // O(n)
    public int solution1(TreeNode root) {
        if(root == null) return 0;

        return 1 + solution1(root.left) + solution1(root.right);
    }
    

    // log(n) to traverse the height of the tree as its a complete binary tree
    // The recursion is again log(n) as when you compare both branches and they are different
    // That means only one side is incomplete, so the recursion only goes one way,
    // How depth can that go = the height of the tree which is log(n)
    // log(n) * log(n) = log2(n)
    public int solution2(TreeNode root) {
        if(root == null) return 0;

        int left = leftHeight(root.left);

        int right = rightHeight(root.right);

        // Then its a perfect node
        if(left == right) {
            return (1 << left) - 1;
        }


        return 1 + solution2(root.left) + solution2(root.right);
    }

    private int leftHeight(TreeNode node) {
        if(node == null) return 0;

        return 1 + leftHeight(node.left);
    }

    private int rightHeight(TreeNode node) {
        if(node == null) return 0;

        return 1 + rightHeight(node.right);
    }
}
 