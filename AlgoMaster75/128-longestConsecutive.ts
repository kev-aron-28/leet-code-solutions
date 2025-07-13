function longestConsecutive(nums: number[]): number {
  const numSet = new Set(nums);
  let longest = 0;
  
  for(const num of numSet) {
    if(!numSet.has(num - 1)) {
      let currentLen = 1;
      let currentNum = num;
      
      while(numSet.has(currentNum + 1)) {
        currentLen++;
        currentNum++;
      }
      
      longest = Math.max(longest, currentLen);
    }
  }
  
  return longest;
  
};
