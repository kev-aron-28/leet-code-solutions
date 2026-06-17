package review-1.TwoPointers.Medium;

public class ContainerWithMostWater {
    public int solution(int height[]) {
        int i = 0;
        int j = height.length - 1;

        int max = 0;
        while(i < j) {
            int minHeight = Math.min(height[i], height[j]);

            int base = j - i;

            max = Math.max(max, minHeight * base);

            if(height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return max;
    }
}
