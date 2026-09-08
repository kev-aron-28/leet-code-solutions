public class FindFirstAndLastPositionOfElement {
    public int[] solution(int nums[], int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        return new int[] { first, last };
    }

    int findLast(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;

        int result = -1;
        while (left <= right) { 
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                result = mid;
                right = mid - 1;
            }
            
            if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    int findFirst(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;

        int result = -1;
        while (left <= right) { 
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                result = mid;
                left = mid + 1;
            }
            
            if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}
