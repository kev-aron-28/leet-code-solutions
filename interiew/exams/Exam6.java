public class Exam6 {
    public int removeDuplicatesFromSortedArray(int nums[]) {
        int left = 0;

        for(int right = 1; right < nums.length; right++) {
            if(nums[left] != nums[right]) {
                nums[++left] = nums[right];
            }
        }

        return left + 1;
    }

    public int removeElement(int nums[], int val) {
        int slowPointer = 0;
        int fastPointer = 0;

        while(fastPointer < nums.length) {
            if(nums[fastPointer] != val) {
                nums[slowPointer] = nums[fastPointer];
                slowPointer++;
            }

            fastPointer++;
        }

        return slowPointer + 1;
    }

    public boolean IsSubsequence(String s, String t) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;
            }

            j++;
        }

        return i == s.length();
    }

    public void mergeTwoSortedArrays(int nums1[], int m, int nums2[], int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }

            k--;
        }

    }

    public int moveZeroes(int nums[]) {
        int slow = 0;
        int fast = 0;

        while(fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }

            fast++;
        }

        return slow;
    }

}
