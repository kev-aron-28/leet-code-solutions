public class ContainerWithMostWater {
    
    public static int maxArea(int heights[]) {
        int left = 0;
        int right = heights.length - 1;

        int result = 0;
        while(left < right) {
            int leftHeight = heights[left];
            int rightHeight = heights[right];

            int height = Math.min(leftHeight, rightHeight);
            int base = right - left;

            int area = height * base;

            result = Math.max(area, result);

            if(leftHeight < rightHeight){
                left++;
            } else {
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        
    }
}
