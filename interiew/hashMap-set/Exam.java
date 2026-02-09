import java.util.HashMap;
import java.util.HashSet;

public class Exam {
    
    public int longestSubstringWithoutRepeatingCharacters(String s) {
        HashSet<Character> count = new HashSet<>();
        
        int left = 0;

        int max = 0;

        for(int right = 0; right < s.length(); right++){ 
            char currentChar = s.charAt(right);
            
            while(count.contains(currentChar)) {
                count.remove(s.charAt(left));
                left++;
            }
            
            count.add(currentChar);
            max = Math.max(max, right - left + 1);
        }

        return max;
    }     

    public int maximumSumSubArrayOfSizeK(int nums[], int k) {

        if(k > nums.length) return 0;

        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right];

            while(right - left + 1 > k) {
                windowSum -= nums[left];
                left++;
            }

            maxSum = Math.max(maxSum, windowSum);

        }

        return maxSum;
    }

    public boolean permutationInArray(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        
        int freq1[] = new int[28];
        int freq2[] = new int[28];

        int right;
        int left = 0;

        for(right = 0; right < s1.length(); right++) {
            freq1[s1.charAt(right) - 'a']++;
            freq2[s2.charAt(right) - 'a']++;
        }

        if(isPermutation(freq1, freq2)) return true;

        while(right < s2.length()) {

            freq2[s2.charAt(right) - 'a']++;
            freq2[s2.charAt(left) - 'a']--;

            if(isPermutation(freq1, freq2)) return true;

            right++;
            left++;
        }
        

        return false;
    }

    public boolean isPermutation(int s1[], int s2[]) {

        for(int i = 0; i < 28; i++) {
            if(s1[i] != s2[i]) return false;
        }

        return true;
    }

    public int fruitIntoBaskets(int fruits[]) {
        HashMap<Integer, Integer> basket = new HashMap<>();

        int left = 0;

        int max = Integer.MIN_VALUE;

        for(int right = 0; right < fruits.length; right++) {
            int rigthFruit = fruits[right];

            basket.put(rigthFruit, basket.getOrDefault(rigthFruit, 0) + 1);

            while (basket.size() > 2) { 
                int leftFruit = fruits[left];

                basket.put(leftFruit, basket.get(leftFruit) - 1);

                if(basket.get(leftFruit) == 0) basket.remove(leftFruit);

                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
    public static void main(String[] args) {
        
    }
}
