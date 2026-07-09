package daily;

public class TrapRainingWater {
    public int solution(int height[]) {
        int leftTallest = 0;
        int rightTallest = 0;

        int left = 0;
        int right = height.length - 1;

        int water = 0;
        while(left < right) {
            if(height[left] < height[right]) {
                if(height[left] > leftTallest) {
                    leftTallest = height[left];
                } else {
                    water += leftTallest - height[left];
                }
                left++;
            } else {
                if(height[right] > rightTallest) {
                    rightTallest = height[right];
                } else {
                    water += rightTallest - height[right];
                }

                right--;
            }
        } 

        return water;
    }
}
