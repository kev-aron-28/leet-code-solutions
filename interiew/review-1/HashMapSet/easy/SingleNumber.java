package review-1.HashMapSet.easy;

public class SingleNumber {
    public int solution(int nums[]) {
        int solution = 0;

        for(int n : nums) {
            solution ^= n;
        }

        return solution;
    }
}
