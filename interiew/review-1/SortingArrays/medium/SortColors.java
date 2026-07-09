package review-1.SortingArrays.medium;

public class SortColors {
    public void solution(int nums[]) {
        int count[] = new int[3];

        for(int c : nums) {
            count[c]++;
        }

        int index = 0;
        for(int i = 0; i < 3; i++) {
            int current = count[i];

            for(int c = 0; c < current; c++) {
                nums[index++] = i;
            }
        }
    }
}
