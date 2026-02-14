
import java.util.HashMap;

public class Exam2 {
    public boolean validPalindrome(String s) {

        int left =0;
        int right = s.length() - 1;


        while(left < right) {
            
            
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if(
                Character.toLowerCase(s.charAt(left)) != 
                Character.toLowerCase(s.charAt(right))
            ) {
                return false;
            }

            left++;
            right--;
        }


        return true;
    }

    public boolean continuousSubarraySum(int nums[], int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        freq.put(0, -1);

        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            int remainder = k == 0 ? prefixSum : prefixSum % k;
        
            if(freq.containsKey(remainder)) {
                int prevIndx = freq.get(remainder);

                if(i - prevIndx >= 2) {
                    return true;
                }

            } else {
                freq.put(remainder, i);
            }
        }

        return false;
    }

    public int rangeSumQuery(int nums[], int left, int right) {
        if(left < 0 || left > nums.length || right > nums.length) return 0;

        int sums[] = new int[nums.length + 1];
        sums[0] = 0;

        int prefixSum = 0;

        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            sums[i + 1] = prefixSum;
        }

        return sums[right + 1] - sums[left];
    }
    
    public static void main(String[] args) {
        
    }
}
