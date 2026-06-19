package review-1.TwoPointers.Medium;

public class SortColors {
    public void solution(int nums[]) {
        int count[] = new int[3];

        for(int n : nums) count[n]++;

        int index = 0;

        for(int i = 0; i < count.length; i++) {
            int current = count[i];

            for(int c = 0; c < current; c++) {
                nums[index++] = i;
            }
        }
    }
}
