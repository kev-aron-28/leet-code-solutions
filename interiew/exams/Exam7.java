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

    
    public int kokoEatingBanans(int piles[], int h) {
        int minBananasPerHour = 1;
        int maxBanansPerHour = 0;

        for(int p : piles) {
            maxBanansPerHour = Math.max(p, maxBanansPerHour);
        }

        while (minBananasPerHour < maxBanansPerHour) { 
            int mid = minBananasPerHour + (maxBanansPerHour - minBananasPerHour) / 2;

            if(canFinish(mid, piles, h)) {
                maxBanansPerHour = mid;
            } else {
                minBananasPerHour = mid + 1;
            }
        }

        return minBananasPerHour;
    }

    private boolean canFinish(int bananasPerHour, int piles[], int maxHours) {
        int hoursTaken = 0;

        for(int i = 0; i < piles.length; i++) {
            hoursTaken += (int)Math.ceil((double)piles[i] / (double)bananasPerHour);
        }

        return hoursTaken <= maxHours;
    }

    public int searchInRotatedSortedArray(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) { 
            int mid = left + (right - left) / 2;
            
            if(nums[mid] == target) {
                return mid;
            }

            if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public int findPeakElement(int nums[]) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid + 1] > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
 