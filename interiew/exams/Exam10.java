import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import trees.TreeNode;

public class Exam10 {
    
    public int binaryTreeMaximumPathSum(TreeNode root) {
        int maxSum[] = { Integer.MIN_VALUE };

        depth(root, maxSum);

        return maxSum[0];
    }

    private int depth(TreeNode node, int maxSum[]) {
        if(node == null) return 0;

        int leftBranch = Math.max(depth(node.left, maxSum), 0);
        int rightBranch = Math.max(depth(node.right, maxSum),0);

        int current = node.val + leftBranch + rightBranch;

        maxSum[0] = Math.max(current, maxSum[0]);

        return node.val + Math.max(leftBranch, rightBranch);
    }


    private int wordLadder(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        if(!set.contains(endWord)) return 0;

        Queue<String> queue = new ArrayDeque<>();

        queue.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) { 
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                String current = queue.poll();

                if(current.equals(endWord)) return level;

                char arr[] = current.toCharArray();

                for(int j = 0; j < arr.length; j++) {
                    char original = arr[j];

                    for(char c = 'a'; c <= 'z'; c++) {
                        arr[j] = c;
                        String next = new String(arr);

                        if(set.contains(next)) {
                            queue.offer(next);
                            set.remove(next);
                        }
                    }

                    arr[j] = original;
                }
            }

            level++;
        }

        return 0;
    }


    private int openTheLock(String deadEnds[], String target) {
        Set<String> set = new HashSet<>(List.of(deadEnds));

        Queue<String> queue = new ArrayDeque<>();
        queue.add("0000");

        Set<String> visited = new HashSet<>();
        visited.add("0000");

        int levels = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                String current = queue.poll();

                if(current.equals(target)) return levels;

                for(String next : getLockCombination(current)) {
                    if(!set.contains(next) && !visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }

            }

            levels++;
        }

        return -1;
    }

    private List<String> getLockCombination(String combination) {
        List<String> result = new ArrayList<>();

        for(int i = 0; i < 4; i++) {
            char arr[] = combination.toCharArray();

            arr[i] = (char)(((arr[i] - '0' + 1) % 10) + '0');
            
            result.add(new String(arr));

            arr = combination.toCharArray();

            arr[i] = (char)(((arr[i] - '0' + 9) % 10) + '0');
            result.add(new String(arr));
        }


        return result;
    } 


    private boolean IsGraphBipartite(int graph[][]) {
        int n = graph.length;
        int color[] = new int[n];

        for(int i = 0; i < n; i++) {
            if(color[i] == 0) {
                if(!IsGraphBipartiteHelper(i, 1, color, graph)) return false;
            }
        }

        return true;
    }

    private boolean IsGraphBipartiteHelper(int node, int currentColor, int color[], int graph[][]) {
        color[node] = currentColor;

        for(int n : graph[node]) {
            if(color[n] == 0) {
                if(!IsGraphBipartiteHelper(n, -currentColor, color, graph)) return false;
            } else if(color[n] == currentColor) {
                return false;
            }
        }

        return true;
    }


    private int townJudge(int n, int graph[][]) {
        int t[] = new int[n + 1];

        for(int trust[] : graph) {
            int a = trust[0];
            int b = trust[1];

            t[a]--;
            t[b]++;
        }

        for(int i = 1; i <= n; i++) {
            if(t[i] == n - 1) return i;
        }


        return -1;
    }
    
}
