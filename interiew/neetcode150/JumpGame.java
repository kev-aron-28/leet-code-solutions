package neetcode150;

public class JumpGame {
    public boolean solution(int nums[]) {
        int reach = 0;

        for(int i = 0; i < nums.length; i++) {

            if(i > reach) {
                return false;
            }
            
            reach = Math.max(reach, i + nums[i]);

            if (i >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}
