
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import trees.TreeNode;

public class Exam1 {
    public int fruitIntoBaskets(int fruits[]) {
        HashMap<Integer,Integer> basket = new HashMap<>();

        int left = 0;
        int right;
        int max = Integer.MIN_VALUE;

        for(right = 0; right < fruits.length; right++) {
            int rightFruit = fruits[right];
            basket.put(rightFruit, basket.getOrDefault(rightFruit, 0) + 1);

            while(basket.size() > 2) {
                int leftFruit = fruits[left];

                basket.put(leftFruit, basket.get(leftFruit) - 1);

                if(basket.get(leftFruit) == 0) {
                    basket.remove(leftFruit);
                }

                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        Integer diameter = 0;

        path(root, diameter);

        return diameter;
    }

    private int path(TreeNode node, Integer diameter) {
        if(node == null) return 0;

        int left = path(node.left, diameter);
        int right = path(node.right, diameter);

        diameter = Math.max(diameter, left + right);

        return 1 + Math.max(left,right);
    }

    int subarraySumEqualsK(int nums[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefixSum = 0;
        
        int count = 0;

        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if(map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public List<List<Integer>> binaryTreeZigzagLevelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        boolean putLeft = true;

        while (!queue.isEmpty()) { 
            int currentLevelSize = queue.size();

            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.poll();

                if(putLeft) {
                    level.addLast(node.val);
                } else {
                    level.addFirst(node.val);
                }

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            result.add(level);
            putLeft = !putLeft;
        }


        return result;
    }

    public int longestSubstringWithoutRepeatingCharacters(String s) {
        HashSet<Character> chars = new HashSet<>();
        
        int left = 0;

        int max = 0;

        for(int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            while(chars.contains(rightChar)) {
                char leftChar = s.charAt(left);

                chars.remove(leftChar);

                left++;
            }

            max = Math.max(max, right - left + 1);

            chars.add(rightChar);
        }

        return max;
    }

    public int maximumSizeSubArraySumEqualsK(int nums[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int prefixSum = 0;

        int max = 0;

        for(int right = 0; right < nums.length; right++) {
            prefixSum += nums[right];

            if(map.containsKey(prefixSum - k)) {
                max = Math.max(max, right - map.get(prefixSum - k));
            }

            map.putIfAbsent(prefixSum, right);
        } 

        return max;
    }

    public boolean balancedBinaryTree(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode node) {
        if(node == null) return 0;

        int left = height(node.left);

        if(left == -1) return -1;

        int right = height(node.right);

        if(right == -1) return -1;

        if(Math.abs(left - right) > 1) {
            return -1;
        }

        return 1 + Math.max(left, right);
    }

    public boolean continuosSubarraySum(int nums[], int k) {

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int prefixSum = 0;

        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if(map.containsKey(prefixSum % k)) {
                if(i - map.get(prefixSum % k) >= 2) return true;
            }

            map.putIfAbsent(prefixSum % k, i);
        }


        return false;
    }

    public String minimumWIndowSubString(String s, String t) {

        Map<Character, Integer> freq = new HashMap<>();

        Map<Character, Integer> window = new HashMap<>();

        for(char current : t.toCharArray()) {
            freq.put(current, freq.getOrDefault(current, 0) + 1);
        }

        int required = freq.size();

        int foundUntilNow = 0;

        int min = Integer.MAX_VALUE;

        int left = 0;

        int stringStarts = 0;

        for(int right = 0; right < s.length(); right++ ) {
            char rightChar = s.charAt(right);

            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);

            if(freq.containsKey(rightChar) && freq.get(rightChar) == window.get(rightChar)) {
                foundUntilNow++;
            }

            while (foundUntilNow == required) { 
                if(right - left + 1 < min) {
                    min = Math.min(min, right - left + 1);

                    stringStarts = left;
                } 

                char leftChar = s.charAt(left);

                window.put(leftChar, window.get(leftChar) - 1);

                if(freq.containsKey(leftChar) && freq.get(leftChar) > window.get(leftChar)) foundUntilNow--;

                left++;
            }
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(stringStarts, stringStarts + min);
    }

    public int[] slidingWindowMaximum(int nums[], int k) {

        int result[] = new int[nums.length - k + 1];
        int index = 0;

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) { 
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) { 
                deque.pollLast();
            }

            deque.addLast(i);


            if (i >= k - 1) {
                result[index++] = nums[deque.peekFirst()];
            }

        }

        return result;
    }

    public List<List<String>> groupAnagrams(String strs[]) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s : strs) {
            char sChars[] = s.toCharArray();
        
            Arrays.sort(sChars);
            
            String sKey = new String(sChars);

            map.putIfAbsent(sKey, new ArrayList<>());

            map.get(sKey).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public double maximumAverageSubArray(int nums[], int k) {

        int windowSum = 0;

        int i;

        for(i = 0; i < k; i++){
            windowSum += nums[i];
        }

        int maxSum = windowSum;

        while(i < nums.length) {

            windowSum += nums[i] - nums[i - k];

            maxSum = Math.max(windowSum, maxSum);

            i++;
        } 

        return (double) maxSum / k;
    }


    public int binarySubArrayWithSum(int nums[], int goal) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int prefixSum = 0;

        int count = 0;

        for(int num : nums) {
            prefixSum += num;

            if(map.containsKey(prefixSum - goal)) {
                count += map.get(prefixSum - goal);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public int countCompleteTreeNodes(TreeNode root) {
        if(root == null) return 0;

        int left = leftNodes(root);

        int right = rightNodes(root);

        if(left == right) {
            return (1 << left) - 1;
        }
        
        return 1 + countCompleteTreeNodes(root.left) + countCompleteTreeNodes(root.right);
    }

    public int leftNodes(TreeNode node) {
        if(node == null) return 0;

        return 1 + leftNodes(node.left); 
    }

    public int rightNodes(TreeNode node) {
        if(node == null) return 0;

        return 1 + rightNodes(node.right);
    }

    public boolean ransomNote(String ransomNote, String magazine) {
        int letters[] = new int[26];

        for(char c : magazine.toCharArray()) {
            letters[c - 'a']++;
        }

        for(char c : ransomNote.toCharArray()) {
            letters[c - 'a']--;

            if(letters[c - 'a'] < 0) return false; 
        }

        return true;
    }
    // Preorder
    public boolean pathSum(TreeNode node, int targetSum) {
        if(node == null) return false;


        if(node.left == null && node.right == null) {
            if(node.val == targetSum) return true;
        }

        int remaining = targetSum - node.val;

        return pathSum(node.left, remaining) || pathSum(node.right, remaining);
    }

}