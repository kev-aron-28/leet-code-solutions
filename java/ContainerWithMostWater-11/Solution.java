class Solution { public int maxArea(int[] height) { int left = 0; int right = height.length - 1; int max = Integer.MIN_VALUE;

        while(left < right) {
            int lH = height[left];
            int rH = height[right];

            int h = lH < rH ? lH : rH; int b = right - left; int area = h * b;

            max = Math.max(area, max);

            if(lH < rH) left++;
            else right--;
        }

        return max;
    }

	public static void main(String args[]) { System.out.println("Hello world");
		
	}

}
