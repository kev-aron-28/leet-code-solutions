package daily;

public class TrapRainingWater {
    public int solution(int height[]) {
        int left = 0;
        int right = height.length - 1;

        int tallestLeft = 0;
        int tallestRight = 0;

        int count = 0;

        while(left < right) {
            if (height[left] <= height[right]) {
                if(height[left] >= tallestLeft) {
                    tallestLeft = height[left];
                } else {
                    count += tallestLeft - height[left];
                }
            }  else {
                if(height[right] >= tallestRight) {
                    tallestRight = height[right];
                } else {
                    count += tallestRight - height[right];
                }
            }
        }

        return count;
    }
}
