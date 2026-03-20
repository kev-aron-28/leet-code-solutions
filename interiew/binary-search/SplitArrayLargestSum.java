public class SplitArrayLargestSum {
    public int solution (int nums[], int k) {
        int minSumPerArray = 0;
        int maxSumPerArray = 0;

        for(int n : nums) {
            minSumPerArray = Math.max(n, minSumPerArray);
            maxSumPerArray += n;
        }

        while (minSumPerArray < maxSumPerArray) { 
            int mid = minSumPerArray + (maxSumPerArray - minSumPerArray) / 2;

            if(canSplit(nums, k, mid)) {
                maxSumPerArray = mid;
            } else {
                minSumPerArray = mid + 1;
            }
        }


        return minSumPerArray;
    }

    public boolean canSplit(int nums[], int k, int x) {
        int subArrays = 1;
        int currSum = 0;

        for(int n : nums) {
            if(currSum + n > x) {
                subArrays++;
                currSum = n;

                if(subArrays > k) return false;

            } else {
                currSum += n;
            }
        }

        return true;
    }
}