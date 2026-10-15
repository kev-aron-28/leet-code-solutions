package audible;

import java.util.*;

public class AsteroidCollision {
    public int[] solution(int asteroids[]) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int asteroid : asteroids) {
            boolean alive = true;

            while(alive && asteroid < 0 && !stack.isEmpty() && stack.peek() > 0) {
                int top = stack.peek();

                if(top < -asteroid) {
                    stack.pop();                    
                } else if(top == -asteroid) {
                    stack.pop();
                    alive = false;
                } else {
                    alive = false;
                }
            }

            if(alive) stack.add(asteroid);
        }

        int result[] = new int[stack.size()];

        for(int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
