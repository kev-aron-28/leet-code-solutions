public class CountNumberOfNiceSubArrays {
    // o que realmente está contando atMost(k)
    public int count(int nums[], int k) {
        
        int oddCount = 0;
        int left = 0;
        int result = 0;
        for(int right = 0; right < nums.length; right++) {
            int rightElement = 0;

            if(rightElement % 2 != 0) {
                oddCount++;
            }
            

            while(oddCount > k) {
                int leftElemnt = nums[left];
                if(leftElemnt % 2 != 0) {
                    oddCount--;
                }
                left++;
            }

            result += right - left + 1;
        }

        return result;
    }

    public int helper (int nums[], int k) {
        return count(nums, k) - count(nums, k - 1);
    }
    
    

    public static void main(String[] args) {
        
    }
}
