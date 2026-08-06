package daily;

public class RelativeSortArray {
    public int[] solution(int arr1[], int arr2[]) {
        int freq[] = new int[1001];

        for(int e : arr1) {
            freq[e]++;
        }

        int index = 0;
        for(int e : arr2) {
            while(freq[e] > 0) {
                arr1[index++] = e;
                freq[e]--;
            }
        }

        for(int i = 0; i < 1001; i++) {
            while (freq[i] > 0) { 
                arr1[index++] = i;
                freq[i]--;
            }
        }

        return arr1;
    }
}
