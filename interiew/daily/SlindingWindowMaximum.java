package daily;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlindingWindowMaximum {
    public int[] solution(int nums[], int k) {
        int n = nums.length;
        int result[] = new int[n - k + 1];

        int idx = 0;

        Deque<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i < nums.length; i++) {

            while(!queue.isEmpty() && queue.peekFirst() < i - k + 1) {
                queue.pollFirst();
            }

            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) { 
                queue.pollLast();
            }

            queue.offerLast(i);

            if(i >= k - 1) {
                result[idx++] = queue.pollFirst();
            }

        }
        return result;
    }    
}
