public class RemoveDuplicatesFromSortedArrayII {
    public int solution(int nums[]) {
        if(nums.length < 3) {
            return nums.length;
        }

        int slow = 2;

        for(int i = 2; i < nums.length; i++) {
            if(nums[i] != nums[slow - 2]) {
                nums[slow++] = nums[i];
            }
        }

        return slow;
    }
}
