function removeDuplicates(nums: number[]): number {
  let slow = 0;
  for(let i = 1; i < nums.length; i++) {
    if(nums[i] !== nums[slow]) {
      slow++;
      nums[slow] = nums[i];
    }
  }
  
  return slow + 1;
};
