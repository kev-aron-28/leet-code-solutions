
import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets {
    public int solution(int fruits[]) {
        Map<Integer, Integer> baskets = new HashMap<>();
        
        int left = 0;
        int right;
        int max = Integer.MIN_VALUE;

        for (right = 0; right < fruits.length; right++) {
            int rightFruit = fruits[right];
            baskets.put(rightFruit, baskets.getOrDefault(rightFruit, 0) + 1);

            while(baskets.size() > 2) {
                int leftFruit = fruits[left];

                baskets.put(leftFruit, baskets.get(leftFruit) - 1);

                if(baskets.get(leftFruit) == 0) {
                    baskets.remove(leftFruit);
                }

                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
    
    
    public static void main(String[] args) {
        
    }
}
