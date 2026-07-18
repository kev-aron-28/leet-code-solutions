package daily;

public class BinarySearch {
    public int solution(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = right - (right -left) / 2;

            if(nums[mid] == target) return mid;

            if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
