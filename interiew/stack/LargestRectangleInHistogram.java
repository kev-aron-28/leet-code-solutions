package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {
    public int solution(int heights[]) {
        Deque<Integer> stack = new ArrayDeque<>();

        int max = 0;

        for(int i = 0; i <= heights.length; i++){
            int currentHeight = i == heights.length ? 0 : heights[i];

            while(!stack.isEmpty() && heights[stack.peek()] > currentHeight) {
                int height = heights[stack.pop()];

                int left = stack.isEmpty() ? -1 : stack.peek();

                int width = i - left - 1;
                int area = height * width;

                max = Math.max(max, area);
            }

            stack.push(i);
        }

        return max;
    }
}
