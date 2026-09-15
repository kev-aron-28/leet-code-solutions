package review-2;

public class SingleNumber {
    public int solution(int nums[]) {
        int x = 0;

        for(int n : nums) {
            x ^= n;
        }

        return x;
    }
}
