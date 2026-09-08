public class FindInMountainArray {
    public int solution(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] < nums[mid + 1]) {
                left = mid + 1; 
            } else {
                right = mid;
            }
        }

        int peak = left;

        int leftFind = binarySearch(nums, 0, peak, target, true);
    
        if(leftFind != -1) return leftFind;

        return binarySearch(nums, peak + 1, right, target, false);
    }

    private int binarySearch(int[] nums, int left, int right, int target, boolean asc) {
        while (left <= right) { 
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) return mid;

            if(asc) {
                if(nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(nums[mid] > target) {
                    left = mid - 1;
                } else {
                    right = mid + 1;
                }
            }
        }

        return -1;
    }


}
