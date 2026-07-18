package daily;

public class SingleNumber {
    public int solution(int nums[]) {
        int res = 0;

        for(int num : nums) {
            res ^= num;
        }

        return res;
    }
}
