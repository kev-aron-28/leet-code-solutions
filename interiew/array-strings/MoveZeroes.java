public class MoveZeroes {
    public static void moveZero(int nums[]) {
        int slow = 0;
        int fast = 0;

        while(fast < nums.length) {
            if(nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        while(slow < nums.length) {
            nums[slow] = 0;
            slow++;
        }
    } 
    public static void main(String[] args) {
        int array[] = { 0, 0, 3,0, 1, 2  };

        moveZero(array);

        for(int num : array) {
            System.out.println(num);
        }
    }
}
