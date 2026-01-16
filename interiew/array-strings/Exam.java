public class Exam {
    public static int removeDuplicatesFromSortedArray(int nums[]) {
        int left = 0;

        for(int right = 1; right < nums.length; right++) {
            if(nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
            }
        }

        return left + 1;
    }

    public static int removeElement(int nums[], int k) {
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if(nums[right] != k) {
                nums[left] = nums[right];
                left++;
            }
        }

        return left;
    }

    public static boolean isSubsequence(String s, String t) {
        int left = 0;
        int right = 0;

        while(left < s.length() && right < t.length()) {
            if(s.charAt(left) == t.charAt(right)) {
                left++;
            }

            right++;
        }

        return left == s.length();
    }

    public static void mergeTwoSortedArrays(int nums[], int n, int nums2[], int m) {
        int left = n  - 1;
        int right = m - 1;
        int k = n + m - 1;

        while (right >= 0) { 
            if(left >= 0 && nums[left] > nums[right]) {
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
        
        for(int right = 0; right < nums.length; right++) {
            if(nums[right] != 0) {
                nums[left] = nums[right];
                left++;
            }
        }

        for(int i = left; i < nums.length; i++) {
            nums[i] = 0;
        }

        return left + 1;
    }

    public static boolean validPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;

            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;

            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;

            left++;
            right--;
        }

        return true;
    }
    
    public static void main(String[] args) {
        int test[] = { 0,0,1,1,1,2,2,3,3,4 };
        String s = "abc";
        String t = "ahbgd";

        String palindrome = "A man, a plan, a canal: Panama";

        System.out.println(Exam.validPalindrome(palindrome));
    }
}
