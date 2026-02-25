package trees;

import java.util.ArrayList;
import java.util.List;

public class PathSumll {
    public List<List<Integer>> solution(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void dfs(TreeNode node, int targetSum, List<Integer> currentPath, List<List<Integer>> result) {
        if(node == null) return;
        
        currentPath.add(node.val);

        if(node.left == null && node.right == null && node.val == targetSum) {
            result.add(new ArrayList<>(currentPath));
        } else {
            dfs(node.left, targetSum - node.val, currentPath, result);
            dfs(node.right, targetSum - node.val, currentPath, result);
        }

        currentPath.remove(currentPath.size() - 1);
    }

}


//         5      
//        / \
//       4   8
//      /   / \
//     11  13  4
//    /  \      \
//   7    2      1