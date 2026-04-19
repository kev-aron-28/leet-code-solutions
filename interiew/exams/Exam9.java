
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Exam9 {
    public List<List<Integer>> subsetsMain(int nums[]) {
        List<List<Integer>> solution = new ArrayList<>();

        subsets_helper(0, nums, new ArrayList<>(), solution);

        return solution;
    } 

    private void subsets_helper(int index, int nums[], List<Integer> path, List<List<Integer>> result) {

        result.add(new ArrayList<>(path));

        for(int i = index; i < nums.length; i++) {
            path.add(nums[i]);

            subsets_helper(i + 1, nums, path, result);
        
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> subsetsIIMain(int nums[]) {
        List<List<Integer>> result = new ArrayList<>();

        subsetsII_helper(0, nums, new ArrayList<>(), result);

        return result;
    }

     private void subsetsII_helper(int index, int nums[], List<Integer> path, List<List<Integer>> result) {

        result.add(new ArrayList<>(path));

        for(int i = index; i < nums.length; i++) {

            if(i > index && nums[i] == nums[i - 1]) continue;

            path.add(nums[i]);

            subsetsII_helper(i + 1, nums, path, result);
        
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combinationsMain(int nums[]) {
        List<List<Integer>> result = new ArrayList<>();


        combinations_helper(0, nums, new ArrayList<>(), result);

        return result;
    }

    private void combinations_helper(int index, int nums[], List<Integer> path, List<List<Integer>> result) {

        if(path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            
            return;
        }

        for(int i = index; i < nums.length; i++) {
            path.add(nums[i]);

            combinations_helper(i + 1, nums, path, result);

            path.remove(path.size() - 1);
        }

    }

    public List<List<Integer>> combinationSum(int nums[], int target) {
        List<List<Integer>> result = new ArrayList<>();

        combinationSum_helper(0, target, nums, new ArrayList<>(), result);

        return result;
    }

    private void combinationSum_helper(int index, int target, int nums[], List<Integer> path, List<List<Integer>> result) {
        
        if(target == 0) {
            result.add(new ArrayList<>(path));
            
            return;
        }


        if(target < 0) return;

        for(int i = index; i < nums.length; i++) {
            path.add(nums[i]);

            combinationSum_helper(index, target - nums[i], nums, path, result);
        
            path.remove(path.size() - 1);
        }

    }


    private List<List<Integer>> combinationSumIIMain(int nums[], int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        combinationSumII_helper(0, target, nums, new ArrayList<>(), result);

        return result;
    }

    private void combinationSumII_helper(int index, int target, int nums[], List<Integer> path, List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<>(path));

            return;
        }

        for(int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i - 1]) continue;
            
            path.add(nums[i]);

            combinationSumII_helper(i + 1, target - nums[i], nums, path, result);

            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combinationSumIIIMain(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();

        combinationSumIII_helper(1, k, n, new ArrayList<>(), result);

        return result;
    }

    private void combinationSumIII_helper(int index, int k, int n, List<Integer> path, List<List<Integer>> result) {
         if (path.size() == k) {
            if (n == 0) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        if(path.size() > k || n < 0) return;

        for(int i = index; i <= 9; i++) {
            if(i > n) break;

            path.add(i);

            combinationSumIII_helper(i + 1, k, n - i, path, result);
        
            path.remove(path.size() - 1);
        }
    }

    public List<String> letterCombinationsOfaPhoneNumber (String digits) {
        List<String> result = new ArrayList<>();

        HashMap<Character, String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        char digitsArray[] = digits.toCharArray();

        letterCombinationsOfaPhoneNumber_helper(0, map, digitsArray, new StringBuilder(), result);

        return result;
    }

    private void letterCombinationsOfaPhoneNumber_helper(int index, HashMap<Character, String> map, char[] digits, StringBuilder path, List<String> result) {
        if(index == digits.length) {
            result.add(path.toString());

            return;
        }


        String digitsForNumber = map.get(digits[index]);

        for(char c : digitsForNumber.toCharArray()) {
            path.append(c);

            letterCombinationsOfaPhoneNumber_helper(index + 1, map, digits, path, result);
        
            path.deleteCharAt(path.length() - 1);
        }
    }


    public List<String> generateParentheses(int n) {
        List<String> result = new ArrayList<>();

        generateParentheses_helper(n, 0, 0, new StringBuilder(), result);

        return result;
    }

    private void generateParentheses_helper(int n, int open, int close, StringBuilder path, List<String> result){
        if(path.length() == n * 2) {
            result.add(path.toString());

            return;
        }

        if(open < n) {
            path.append("(");
            generateParentheses_helper(n, open + 1, close, path, result);
            path.deleteCharAt(path.length() - 1);
        }

        if(close < open) {
            path.append(")");
            generateParentheses_helper(n, open, close + 1, path, result);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public List;

}
