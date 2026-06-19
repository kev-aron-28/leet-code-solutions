package review-1.TwoPointers.hard;

public class TrappingRainingWater {
    public int solution(int height[]) {
        int left = 0;
        int right = height.length - 1;

        int leftmax = 0;
        int rightMax = 0;

        int water = 0;

        while(left < right) {
            if(height[left] < height[right]) {

                if (height[left] > leftmax) {
                    leftmax = height[left];
                } else {
                    water += leftmax - height[left];
                }

                left++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }

                right--;
            }
        }

        return water;
    }
}
