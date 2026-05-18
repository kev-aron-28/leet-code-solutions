package common;

public class ContainerWithMostWater {
    public int solution(int heights[]) {
        int left = 0;
        int right = heights.length - 1;

        int max = 0;

        while(left < right) {
            int minHeight = Math.min(heights[left], heights[right]);
            int base = right - left;

            max = Math.max(max, minHeight * base);

            if(heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
