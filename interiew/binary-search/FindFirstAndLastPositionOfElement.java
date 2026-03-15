package binary-search;

public class FindFirstAndLastPositionOfElement {
    public int[] solution(int nums[], int target) {
        int first = findfirst(nums, target);
        int last = findLast(nums, target);

        return new int[] {first,last};
    }

    public int findfirst(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;

        int result = -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if(target > mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public int findLast(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;

        int result = -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if(target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
