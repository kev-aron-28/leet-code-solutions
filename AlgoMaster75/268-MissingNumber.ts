function missingNumber(nums: number[]): number {
  const n = nums.length;
  const seen = new Array(n + 1).fill(false);

  for(let i = 0; i < n; i++) {
    seen[nums[i]] = true;    
  }


  for(let i = 0; i <= n; i++) {
    if(!seen[i]) {
      return i;
    }
  }

  return n;
};
