function productExceptSelf(nums: number[]): number[] {
  const len = nums.length;
  const result = new Array(len);

  let prefix = 1;
  for (let i = 0; i < len; i++) {
    result[i] = prefix;
    prefix *= nums[i];
  }

  let suffix = 1;
  for (let i = len - 1; i >= 0; i--) {
    result[i] *= suffix;
    suffix *= nums[i];
  }

  return result;
};

productExceptSelf([1, 1, 2, 6]);
