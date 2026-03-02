package trees;

public class SumRootToLeafNumbers {
    public int solution(TreeNode root) {

        return preOrder(root,0);
    }

    private int preOrder(TreeNode node, int currentNumber) {

        if(node == null) return 0;

        currentNumber = currentNumber * 10 + node.val;

        if(node.left == null && node.right == null) return currentNumber;

        return preOrder(node.left, currentNumber) + preOrder(node.right, currentNumber);
    }


}
