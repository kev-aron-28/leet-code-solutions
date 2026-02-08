import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Exam {
    

    public List<Integer> substringWithConcatenationOfAllWords(String s, String words[]) {
        List<Integer> result = new ArrayList<>();
        
        if(words == null || s == null || words.length == 0) return result;
        
        int wordSize = words[0].length();
        int concatSize = wordSize * words.length;
        int requiredWords = words.length;

        if(s.length() < concatSize) return result;

        HashMap<String, Integer> required = new HashMap<>();

        for(String word : words) {
            required.put(word, required.getOrDefault(word, 0) + 1);
        }
        

        for(int offset = 0; offset < wordSize; offset++) {
            int left = offset;

            HashMap<String, Integer> window = new HashMap<>();
            int foundWords = 0;

            for(int right = offset; right + wordSize <= s.length(); right += wordSize) {
                String word = s.substring(right, right + wordSize);
                
                if(required.containsKey(word)) {
                    window.put(word, window.getOrDefault(word, 0) + 1);

                    foundWords++;

                    while (required.get(word) < window.get(word)) { 
                        String leftWord = s.substring(left, left + wordSize);

                        window.put(leftWord, window.get(leftWord) - 1);

                        foundWords--;

                        left += wordSize;
                    }


                    if(foundWords == requiredWords) result.add(left);

                } else {
                    window.clear();
                    foundWords = 0;
                    left = wordSize + right;
                }
            }
        }

        return result;
    } 

    public int countNumberOFNiceSubArrays(int nums[], int k) {
        return atMostNiceSubArrays(nums, k) - atMostNiceSubArrays(nums, k - 1);
    }

    public int atMostNiceSubArrays(int nums[], int k) {

        int left = 0;
        int oddCount = 0;
        int result = 0;
        for(int right = 0; right < nums.length; right++) {
            int rightElement = nums[right];
            
            if(rightElement % 2 != 0) oddCount++;

            while(oddCount > k) {
                int leftElement = nums[left];

                if(leftElement % 2 != 0) oddCount--;

                left++;
            }

            result += right - left + 1;
        }

        return result;
    }

    // Only Q W E R
    public int replaceTheSubStringForBalancedString(String s) {
        int n = s.length();

        int requiredFreq = n / 4;

        int freq[] = new int[128];

        for(char c : s.toCharArray()) {
            freq[c]++;
        }

        if(
            freq['Q'] == requiredFreq &&
            freq['W'] == requiredFreq &&
            freq['E'] == requiredFreq &&
            freq['R'] == requiredFreq
        ) {
            return 0;
        }


        int left = 0;
        int min = Integer.MAX_VALUE;

        for(int right = 0; right < s.length(); right++) {
            char rigthChar = s.charAt(right);

            freq[rigthChar]--;

            while(
                left < s.length() &&
                freq['Q'] <= requiredFreq &&
                freq['W'] <= requiredFreq &&
                freq['E'] <= requiredFreq &&
                freq['R'] <= requiredFreq
            ) {
                min = Math.min(min, right - left + 1);

                char leftChar = s.charAt(left);

                freq[leftChar]++;

                left++;
            }
        }


        return min;
    }

    public int substringsWIthSizeKwithKDistinctCharacters(String s, int k) {
        HashMap<Character, Integer> freq = new HashMap<>();

        int left = 0;

        int result = 0;

        for(int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            freq.put(rightChar, freq.getOrDefault(rightChar, 0) + 1);

            while (right - left + 1 > k) { 
                char leftChar = s.charAt(left);

                freq.put(leftChar, freq.get(leftChar) - 1);

                if(freq.get(leftChar) == 0) freq.remove(leftChar);

                left++;
            }

            if(right - left + 1 == k && freq.size() == k) result++;
        }

        return result;
    }

    public int longestSubstringWIthAtMostKDistinctCharacter(String s, int k) {
        HashMap<Character, Integer> freq = new HashMap<>();

        if(k > s.length() || k == 0) return 0;

        int left = 0;

        int max = Integer.MIN_VALUE;

        for(int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            freq.put(rightChar, freq.getOrDefault(rightChar, 0) + 1);

            while (freq.size() > k) { 
                char leftChar = s.charAt(left);

                freq.put(leftChar, freq.get(leftChar) - 1);

                if(freq.get(leftChar) == 0) freq.remove(leftChar);

                left++;
            }

            max = Math.max(max, right - left + 1);
        }


        return 0;
    }

    public boolean permutationInString(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int freq1[] = new int[26];
        int freq2[] = new int[26];

        int left = 0;
        int right;
        for(right = 0; right < s1.length(); right++) {
            freq1[s1.charAt(right) - 'a']++;
            freq2[s2.charAt(right) - 'a']++;
        }

        if(isValidPermutation(freq1, freq2)) return true;


        while(right < s2.length()) {
            freq2[s2.charAt(right) - 'a']++;
            freq2[s2.charAt(left) - 'a']--;
            
            if(isValidPermutation(freq1, freq2)) return true;
            
            right++;
            left++;
        }


        return false;
    }

    public boolean isValidPermutation(int freq1[], int freq2[]) {

        for(int i = 0; i < freq1.length; i++) {
            if(freq1[i] != freq2[i]) return false;
        }

        return true;
    }


    public int fruitsIntoBaskets(int fruits[]) {
        if(fruits.length == 0) return 0;
        
        HashMap<Integer, Integer> freq = new HashMap<>();

        int left = 0;

        int max = Integer.MIN_VALUE;

        for(int right = 0; right < fruits.length; right++) {
            int rightFruit = fruits[right];

            freq.put(rightFruit, freq.getOrDefault(rightFruit, 0) + 1);

            while(freq.size() > 2) {
                int leftFruit = fruits[left];

                freq.put(leftFruit, freq.get(leftFruit) - 1);

                if(freq.get(leftFruit) == 0) freq.remove(leftFruit);

                left++;
            }

            max = Math.max(right - left + 1, max);
        }


        return max;
    }

    public int containerWithMostWater (int heights[]) {
        int left = 0;
        int right = heights.length - 1;

        int max = Integer.MIN_VALUE;

        while(left < right) {
            int leftH = heights[left];
            int rightH = heights[right];

            int height = leftH < rightH ? leftH : rightH;

            int base = right - left;

            int area = height * base;

            max = Math.max(area, max);

            if(leftH < rightH) {
                left++;
            } else {
                right--;
            }

        }

        return max;
    }

    public int subArraySumEqualsK(int nums[], int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        freq.put(0, 1);

        int count = 0;

        int prefixSum = 0;

        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if(freq.containsKey(prefixSum - k)) {
                count += freq.get(prefixSum - k);
            }

            freq.put(prefixSum, freq.getOrDefault(prefixSum, 0) + 1);
        }


        return count;
    }


    public static void main(String[] args) {
        
    }
}
