
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Exam8 {
    public int longestSubstringWithoutRepeatingCharacters(String s) {
        int longest = 0;
        Set<Character> set = new HashSet<>();

        int left = 0;
        int right = 0;

        while (right < s.length()) { 
            char currentChar = s.charAt(right);

            while(set.contains(currentChar)) {
                
                set.remove(s.charAt(left));
                
                left++;
            }
            
            set.add(currentChar);

            longest = Math.max(longest, right - left + 1);
            
            right++;
        }

        return longest;
    }

    public int maximumSumSubarrayOfSizeK(int nums[], int k) {
        
        int currentWindow = 0;
        int i;
        for(i = 0; i < k; i++) {
            currentWindow += nums[i];
        }
        
        int max = currentWindow;

        while(i < nums.length) {
            currentWindow += nums[i] - nums[i - k];

            max = Math.max(currentWindow, max);
            i++;
        }
        return max;
    }

    public boolean permutationInString(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        
        int freq1[] = new int[26];
        int freq2[] = new int[26];

        for(int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        if(matches(freq1, freq2)) return true; 

        int left = 0;
        for(int right = s1.length(); right < s2.length(); right++) {
            freq2[s2.charAt(right) - 'a']++;
            freq2[s2.charAt(left) - 'a']--;

            if(matches(freq1, freq2)) return true;

            left++;
        }


        return false;
    }

    public String minimumWindowSubstring(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> windowMap = new HashMap<>();

        Map<Character, Integer> tMap = new HashMap<>();

        for(char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int right = 0;
        int left = 0;
        int needed = tMap.size();
        int matched = 0;

        int minLen = Integer.MAX_VALUE;
        int startOfString = 0;

        while (right < s.length()) {
            char rightChar = s.charAt(right);

            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);

            if(tMap.containsKey(rightChar) && tMap.get(rightChar).equals(windowMap.get(rightChar))) {
                matched++;
            }

            while(matched == needed) {
                if(right - left + 1 < minLen) {
                    startOfString = left;
                    minLen = right - left + 1;
                }

                char leftChar = s.charAt(left);
                
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
            
                if(tMap.containsKey(leftChar) && tMap.get(leftChar) > windowMap.get(leftChar)) {
                    matched--;
                }

                left++;
            }


            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startOfString, startOfString + minLen);
    }

    public int[] slidingWindowMaximum(int nums[], int k) {
        int result[] = new int[nums.length - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;

        for(int i = 0; i < nums.length; i++) {

            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) { 
                deque.removeFirst();
            }

            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.removeLast();
            }
            
            deque.addLast(i);
            if( i >= k - 1) {
                result[index++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
