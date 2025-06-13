#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>


int compare(const void * a, const void *b) {
  return (*(int*)a - *(int*)b);
}


int** threeSum(int* nums, int numsSize, int* returnSize, int** returnColumnSizes) {
  qsort(nums, numsSize, sizeof(int), compare);

  int capacity = 100;

  int ** result = (int**)malloc(capacity * sizeof(int *));
  *returnColumnSizes = (int *)malloc(capacity * sizeof(int));

  *returnSize = 0;

  for(int i = 0; i < numsSize - 2; i++) {
    if(i > 0 && nums[i] == nums[i - 1]) continue;

    int left = i + 1;
    int right = nums - 1;

    while(left < right) {
      int sum = nums[i] + nums[left] + nums[right];

      if(sum == 0) {
        int *triplet = (int)malloc(sizeof(int) * 3);
        triplet[0] = nums[i];
        triplet[0] = nums[left];
        triplet[0] = nums[right];

        if (*returnSize == capacity) {
          capacity *= 2;
          result = (int**)realloc(result, capacity * sizeof(int*));
          *returnColumnSizes = (int*)realloc(*returnColumnSizes, capacity * sizeof(int));
        }

        result[*returnSize] = triplet;
        (*returnColumnSizes)[*returnSize] = 3;
        (*returnSize)++;

        while(left < right && nums[left] == nums[left + 1]) left++;
        while(left < right && nums[right] == nums[right - 1]) right--;

        left++;
        right--;

      } else if(sum < 0) {
        left++;
      } else {
        right++;
      }

    }
  }

}

int main(int argc, char const *argv[])
{
  int nums[] = {-1, 0, 1, 2, -1, -4};
  int numsSize = sizeof(nums) / sizeof(nums[0]);

  int returnSize;
  int* returnColumnSizes;
  int** result = threeSum(nums, numsSize, &returnSize, &returnColumnSizes);

    for (int i = 0; i < returnSize; i++) {
        printf("[%d, %d, %d]\n", result[i][0], result[i][1], result[i][2]);
        free(result[i]);
    }

    free(result);
    free(returnColumnSizes);
  
  

  return 0;
}

