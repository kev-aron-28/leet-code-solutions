import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Exam {

    public static int removeDuplicatesFromSortedArray(int nums[]) {
        int left = 0;

        for (int right = 1; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
            }
        }

        return left + 1;
    }

    public static int removeElement(int nums[], int k) {
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != k) {
                nums[left] = nums[right];
                left++;
            }
        }

        return left;
    }

    public static boolean isSubsequence(String s, String t) {
        int left = 0;
        int right = 0;

        while (left < s.length() && right < t.length()) {
            if (s.charAt(left) == t.charAt(right)) {
                left++;
            }

            right++;
        }

        return left == s.length();
    }

    public static void mergeTwoSortedArrays(int nums[], int n, int nums2[], int m) {
        int left = n - 1;
        int right = m - 1;
        int k = n + m - 1;

        while (right >= 0) {
            if (left >= 0 && nums[left] > nums[right]) {
                nums[k] = nums[left];
                left--;
            } else {
                nums[k] = nums2[right];
                right--;
            }
        }
        k--;
    }

    public static int moveZeroes(int nums[]) {
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                nums[left] = nums[right];
                left++;
            }
        }

        for (int i = left; i < nums.length; i++) {
            nums[i] = 0;
        }

        return left + 1;
    }

    public static boolean validPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static int[] twoSumTwo(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{};
    }

    public static int containerWithMostWater(int height[]) {

        int left = 0;
        int right = height.length - 1;

        int result = 0;

        while (left < right) {
            int currentHeight = height[left] < height[right] ? height[left] : height[right];

            int base = right - left;

            int area = currentHeight * base;

            result = Math.max(area, result);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

        }

        return result;
    }

    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static int[] squaresOfSortedArray(int nums[]) {
        int result[] = new int[nums.length];

        int left = 0;
        int right = nums.length - 1;
        int position = nums.length - 1;

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (rightSquare > leftSquare) {
                result[position--] = rightSquare;
                right--;
            } else {
                result[position--] = leftSquare;
                left++;
            }
        }

        return result;
    }

    public static double maximumAvarageSubArray(int nums[], int k) {

        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int maxSum = windowSum;

        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];

            maxSum = Math.max(windowSum, maxSum);
        }

        return (double) maxSum / k;
    }

    public static int maximumSumSubArrayOfSizeK(int nums[], int k) {
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int maxSum = windowSum;

        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];

            maxSum = Math.max(windowSum, maxSum);
        }

        return maxSum;
    }

    public static int dietPlanPerformance(int calories[], int k, int lower, int upper) {
        int windowSum = 0;
        int totalPoints = 0;
        for (int i = 0; i < k; i++) {
            windowSum += calories[i];
        }

        if (windowSum < lower) {
            totalPoints--;
        } else if (windowSum > upper) {
            totalPoints++;
        }

        for (int i = k; i < calories.length; i++) {
            windowSum += calories[i] - calories[i - k];

            if (windowSum < lower) {
                totalPoints--;
            } else if (windowSum > upper) {
                totalPoints++;
            }
        }

        return totalPoints;
    }

    public static int longestSubstringWithoutRepeatingChars(String s) {

        Set<Character> set = new HashSet<>();
        
        int left = 0;

        int max = Integer.MIN_VALUE;
        for(int right = 0; right < s.length(); right++) {
            Character currentChar = s.charAt(right);

            while(set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(currentChar);

            max = Math.max(right - left + 1, max);
        }

        return max;
    } 

    public static String minimumWindowSubString(String s, String t) {

        if(s.length() < t.length()) return "";

        Map<Character, Integer> need = new HashMap<>();


        Map<Character, Integer> currentWindow = new HashMap<>();

        for(char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int required = need.size();

        int soFarFormed = 0;

        int min = Integer.MAX_VALUE;

        int startOfString = 0;

        int left = 0;

        for(int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            currentWindow.put(currentChar, currentWindow.getOrDefault(currentChar, 0) + 1);

            if(need.containsKey(currentChar) && need.get(currentChar).intValue() == currentWindow.get(currentChar).intValue()) {
                soFarFormed++;
            }

            while(soFarFormed == required) {
                int currentSizeWindow = right - left + 1;
                if (currentSizeWindow < min) {
                    min = currentSizeWindow;
                    startOfString = left;
                }

                char currentLeftChar = s.charAt(left);

                currentWindow.put(currentLeftChar, currentWindow.get(currentLeftChar) - 1);

                if(need.containsKey(currentLeftChar) && need.get(currentLeftChar).intValue() > currentWindow.get(currentLeftChar).intValue()) {
                    soFarFormed--;
                }

                left++;
            }
        }


        return min == Integer.MAX_VALUE ? "" : s.substring(startOfString, startOfString +  min);
    }
    
    public static int longestRepeatingCharacterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        int longest = 0;
        int left = 0;
        int maxFrequencyChar = 0;

        for(int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);

            maxFrequencyChar = Math.max(map.get(currentChar), maxFrequencyChar);

            int currentLen = right - left + 1;
            int charsToReplace = currentChar - maxFrequencyChar;

            while (charsToReplace > k) { 
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);

                left++;
            }

            longest = Math.max(currentLen, longest);
        }

        return longest;
    }

    public static int fruitsIntoBaskets(int fruits[]) {
        int MAX_ALLOWED = 2;
        int left = 0;

        int max = Integer.MIN_VALUE;

        Map<Integer, Integer> map = new HashMap<>();

        for(int right = 0; right < fruits.length; right++) {
            int current = fruits[right];
            map.put(current, map.getOrDefault(current, 0) + 1);

            while(map.size() > MAX_ALLOWED) {
                int leftValue = fruits[left];
                map.put(leftValue, map.get(leftValue) - 1);

                if(map.get(leftValue) == 0) map.remove(leftValue);
                
                left++;
            }

            max = Math.max(right - left + 1, max);
        }


        return max;
    }

    public static void main(String[] args) {
        int test[] = {-4, -1, 0, 3, 10};
        String s = "abc";

        String palindrome = "A man, a plan, a canal: Panama";
        char t[] = {'h', 'e', 'l', 'l', 'o'};

        String longest = "pwwkew";

        System.out.println(Exam.longestSubstringWithoutRepeatingChars(longest));

    }
}
