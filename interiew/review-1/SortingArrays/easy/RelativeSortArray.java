package review-1.SortingArrays.easy;

public class RelativeSortArray {
    public int[] solution(int[] arr1, int arr2[]) {
        int[] freq = new int[1001];

        for (int num : arr1) {
            freq[num]++;
        }

        int index = 0;

        // Elements in arr2 order
        for (int num : arr2) {
            while (freq[num] > 0) {
                arr1[index++] = num;
                freq[num]--;
            }
        }

        // Remaining elements in ascending order
        for (int i = 0; i < 1001; i++) {
            while (freq[i] > 0) {
                arr1[index++] = i;
                freq[i]--;
            }
        }

        return arr1;
    }
}
