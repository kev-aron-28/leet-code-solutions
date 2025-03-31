#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>

int maxArea(int* height, int heightSize) {
 int left = 0;

 int right = heightSize - 1;

 int max_container = 0;

 while(left < right) {
  int h = height[left] > height[right] ? height[right] : height[left];

  int base = right - left;

  int area = h * base;

  if(area > max_container) {
    max_container = area;
  }

  if(height[left] < height[right]) {
    left++;
  } else {
    right--;
  }
 }
 
 return max_container;
}

int main(int argc, char const *argv[])
{
  /* code */

  int height[] = { 1,8,6,2,5,4,8,3,7 };
  int size = 9;

  printf("RESULT %d \n", maxArea(height, size));

  return 0;
}
