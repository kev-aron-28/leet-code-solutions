package neetcode150;

public class JumpGameII {
    public int solution(int nums[]) {
        int farthest = 0;
        int jumps = 0;
        int end = 0;

        for(int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == end) {
                jumps++;
                end = farthest;
            }
        }

        return jumps;
    }
}
