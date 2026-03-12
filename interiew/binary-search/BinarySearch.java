package binary-search;

public class BinarySearch {
    public int solution(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) { 
            int middle = (left + right) / 2;

            if(nums[middle] == target) {
                return middle;
            } else if(nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }


        return -1;
    }
}
