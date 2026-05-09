
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import trees.TreeNode;

public class Exam11 {
    public List<List<Integer>> subsets(int nums[]) {
        List<List<Integer>> result = new ArrayList<>();

        subsetsHelper(0, nums, new ArrayList<>(), result);

        return result;
    }

    private void subsetsHelper(int start, int nums[], List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for(int i = 0; i < nums.length; i++) {
            current.add(nums[i]);

            subsetsHelper(i + 1, nums, current, result);

            current.remove(current.size() - 1);
        }
    }

    public List<List<Integer>> combinationSumII(int candidates[], int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);

        combinationSumIIHelper(0,candidates, target, new ArrayList<>(), result);

        return result;
    }

    public void combinationSumIIHelper(int index,int candidates[], int target, List<Integer> path, List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            if(i > index && candidates[i] == candidates[i - 1]) continue; 

            if(candidates[i] > target) break; 

            path.add(candidates[i]);

            combinationSumIIHelper(i + 1, candidates, target - candidates[i], path, result);
        
            path.remove(path.size() - 1);
        }
    }

    public boolean balancedBinaryTree(TreeNode root) {
        return balancedBinaryTreeHelper(root) != -1;
    }

    public int balancedBinaryTreeHelper(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int left = balancedBinaryTreeHelper(node.left);

        if(left == -1) return -1;

        int right = balancedBinaryTreeHelper(node.right);

        if(right == -1) return -1;

        if(Math.abs(left - right) > 1) {
            return -1;
        }

        return 1 + Math.max(left, right);
    }

    public List<String> restoreIPAddress(String s) {
        List<String> result = new ArrayList<>();

        restoreIPAddressHelper(0, s, new ArrayList<>(), result);

        return result;
    }

    private void restoreIPAddressHelper(int index, String s, List<String> path, List<String> result) {

        if(path.size() == 4) {
            if(index == s.length()) {
                result.add(String.join(".", path));
            }

            return;
        }

        for(int i = 1; i <= 3; i ++) {
            if(index + i > s.length()) break;

            String current = s.substring(index, index + i);

            if(!isValidIp(current)) continue;

            path.add(current);

            restoreIPAddressHelper(index + i, s, path, result);

            path.remove(path.size() - 1);
        }

    }

    private boolean isValidIp(String ip) {
        if(ip.length() > 1 && ip.startsWith("0")) {
            return false;
        }

        return Integer.parseInt(ip) <= 255;
    }

    int max = Integer.MIN_VALUE;

    public int diameterOfABinaryTree(TreeNode root) {
        diameterOfABinaryTreeHelper(root);
        return max;
    }

    public int diameterOfABinaryTreeHelper(TreeNode node) {
        if(node == null) return 0;

        int left = diameterOfABinaryTreeHelper(node.left);
        int right = diameterOfABinaryTreeHelper(node.right);

        max = Math.max(max, left + right);

        return 1 + Math.max(left, right);
    }

    public List<List<Integer>> allPathsFromSourceToTarget(int graph[][]){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0);
        
        allPathsFromSourceToTargetHelper(0, graph, path, result);

        return result;
    }

    private void allPathsFromSourceToTargetHelper(int node, int graph[][], List<Integer> path, List<List<Integer>> result) {
        if(node == graph.length - 1) {
            result.add(new ArrayList<>(path));

            return;
        }

        for(int next : graph[node]) {
            path.add(next);

            allPathsFromSourceToTargetHelper(next, graph, path, result);

            path.remove(path.size() - 1);
        }
    }

}
