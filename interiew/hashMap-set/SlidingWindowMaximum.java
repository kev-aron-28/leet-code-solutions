
import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public int[] slidingWindowMaximum(int nums[], int k) {
        int n = nums.length;

        int result[] = new int[n - k + 1];
        int currentIndex = 0;
        
        Deque<Integer> candidates = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            while(!candidates.isEmpty() && candidates.peekFirst() < i - k + 1) {
                candidates.pollFirst();
            } 

            while(!candidates.isEmpty() && nums[candidates.peekLast()] < nums[i]) {
                candidates.pollLast();
            }
            
            candidates.offerLast(i);

            if(i >= k - 1) {
                result[currentIndex++] = nums[candidates.peekFirst()];
            }
        }

        return result;
    }
    
    public static void main(String[] args) {
        
    }
}
