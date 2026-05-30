package common;

public class BinarySearch {
    public int solution(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) { 
            int middle = left + (right - left) /2;
            int current = nums[middle];

            if(current == target) {
                return middle;
            } else if (current < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }
}
