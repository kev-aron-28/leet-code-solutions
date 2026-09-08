package daily;

public class CountOfRangeSum {
    public int solution(int nums[], int lower, int upper) {
        int count = 0;

        for(int i = 0; i < nums.length; i++) {
            long sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum += nums[j];

                if(sum >= lower && sum <= upper) count++;
            }
        }

        return count;
    }
}
