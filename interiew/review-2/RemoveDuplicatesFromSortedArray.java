package review-2;

public class RemoveDuplicatesFromSortedArray {
    public int solution(int nums[]) {
        int slow = 0;

        for(int fast = 1; fast < nums.length; fast++) {
            if(nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }

        return slow + 1;
    }

}
