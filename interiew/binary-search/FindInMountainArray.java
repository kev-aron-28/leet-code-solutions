package binary-search;

public class FindInMountainArray {
    
 // This is MountainArray's API interface.
 // You should not implement it, or speculate about its implementation
    interface MountainArray {
        public int get(int index);
        public int length();
    }

    public int solution(int target, MountainArray mountainArray) {
        int n = mountainArray.length();
        int left = 0;
        int right = n - 1;

        while (left < right) { 
            int mid = left + (right - left) / 2;
        
            if(mountainArray.get(mid) < mountainArray.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int peak = left;

        int leftIndex = binarySearch(mountainArray, target, 0, peak, true);

        if(leftIndex != -1) return leftIndex;

        return binarySearch(mountainArray, target, peak + 1, n - 1, false);
    } 

    private int binarySearch(MountainArray arr, int target, int left, int right, boolean asc) {

        while (left <= right) { 
            int mid = left + (right - left) / 2;
            int value = arr.get(mid);

            if(value == target) return mid;

            if(asc) {
                if(value < target) left = mid + 1;
                else right = mid - 1;
            } else {
                if(value < target) right = mid - 1;
                else left = mid + 1;
            }
        }


        return -1;
    }
}
