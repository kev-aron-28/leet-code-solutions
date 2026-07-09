package platform;

public class BinarySearch {
    public int solution(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            int current = nums[mid];

            if(current == target) return mid;

            if(current < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
