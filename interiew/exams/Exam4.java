import java.util.HashMap;
import trees.TreeNode;

public class Exam4 {
    public int binaryTreeMaximumPathSum(TreeNode root) {
        int result[] = { Integer.MIN_VALUE };

        maximumSum(root, result);

        return result[0];
    }


    public int maximumSum(TreeNode node, int result[]) {
        if(node == null) return 0;

        int left = Math.max(maximumSum(node.left, result), 0);

        int right = Math.max(maximumSum(node.right, result),0);

        int val = node.val + left + right;

        result[0] = Math.max(result[0], val);

        return node.val + Math.max(left, right);
    }

    public int pathSumIII(TreeNode root, int targetSum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        return totalPathsSumIs(root, targetSum, map, 0);
    }

    public int totalPathsSumIs(TreeNode node, int targetSum, HashMap<Integer, Integer> map, int prefixSum) {
        if(node == null) return 0;

        prefixSum += node.val;

        int count = map.getOrDefault(prefixSum - targetSum, 0);

        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);

        count += totalPathsSumIs(node.left, targetSum, map, prefixSum);

        count += totalPathsSumIs(node.right, targetSum, map, prefixSum);

        map.put(prefixSum, map.get(prefixSum) - 1);

        return count;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int result[] = { 0 };
        diameter(root, result);
        return result[0];
    }

    public int diameter(TreeNode root, int result[]) {
        if(root == null) return 0;

        int left = diameter(root.left, result);

        int right = diameter(root.right, result);

        result[0] = Math.max(result[0], left + right);

        return 1 + Math.max(left, right);
    }


    public int isBalanced(TreeNode node) {
        if(node == null) return 0;

        int left = isBalanced(node.left);

        if(left == -1) return -1;

        int right = isBalanced(node.right);

        if(right == -1) return -1;

        if(Math.abs(left - right) > 1) return -1;

        return 1 + Math.max(left, right);
    }
}
