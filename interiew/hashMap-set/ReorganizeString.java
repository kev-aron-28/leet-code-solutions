
import java.util.PriorityQueue;

public class ReorganizeString {
    public String solution(String s) {
        int freq[] = new int[26];
        int FREQUENCY = 1;
        int CHARACTER = 0;


        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a,b) -> b[FREQUENCY] - a[FREQUENCY]
        );

        for(int i = 0; i < 26; i++) {
            if(freq[i] > 0) {
                maxHeap.add(new int[] { i, freq[i] });
            }
        }

        StringBuilder result = new StringBuilder();

        int prev[] = null;

        while (!maxHeap.isEmpty()) { 
            int current[] = maxHeap.poll();

            result.append( (char) (current[CHARACTER] + 'a' ));
        
            current[FREQUENCY]--;

            if(prev != null && prev[FREQUENCY] > 0) {
                maxHeap.add(prev);
            }

            prev = current;
        }

        return s.length() == result.length() ? result.toString() : "";
    }
}
