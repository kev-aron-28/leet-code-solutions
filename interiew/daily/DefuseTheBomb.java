package daily;

public class DefuseTheBomb {
    public int[] solution(int codes[], int k) {
        int n = codes.length;

        int result[] = new int[n];

        if(k == 0) return result;

        int start;
        int end;

        if(k > 0) {
            start = 1;
            end = k;
        } else {
            start = n + k;
            end = n - 1;
        }

        int window = 0;
        for(int i = start; i <= end; i++) {
            window += codes[i % n];
        }

        for(int i = 0; i < n; i++) {
            result[i] = window;

            window -= codes[start % n];

            start++;
            end++;

            window += codes[end % n];
        }

        return result;
    }
}
