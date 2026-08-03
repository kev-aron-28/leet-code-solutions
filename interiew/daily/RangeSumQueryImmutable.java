package daily;

public class RangeSumQueryImmutable {
    int prefix[];

    public RangeSumQueryImmutable(int nums[]) {
        prefix = new int[nums.length];
        int p = 0;

        for(int i = 0; i < nums.length; i++) {
            p += nums[i];
            prefix[i] = p;
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return prefix[right];
        }

        return prefix[right] - prefix[left - 1];
    }
}
