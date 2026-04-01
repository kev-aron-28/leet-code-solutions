public class Exam7 {
    public int searchInsertPosition(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) { 
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }


    public int[] firstAndLastPosition(int nums[], int target) {
        int first = first(nums, target);
        int right = last(nums, target);

        return new int[] {first, right};
    }

    private int first(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;

        int result = -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                right = mid - 1;
                result = mid;
            } else if(target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private int last(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;

        int result = -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                left = mid + 1;
                result = mid;
            } else if(target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    

}
