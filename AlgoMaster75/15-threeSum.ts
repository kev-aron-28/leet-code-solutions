function threeSum(nums: number[]): number[][] {
  const sortedArray = nums.sort((a, b) => a - b);

  let triplets: number[][] = [];

  for(let i = 0; i < sortedArray.length - 2; i++) {
    const fixedX = sortedArray[i];

    if(i > 0 && sortedArray[i] == sortedArray[i - 1]) continue;

    let fixedYIndex = i + 1;
    let fixedZIndex = sortedArray.length - 1;
    let target = -fixedX;

    while(fixedYIndex < fixedZIndex) {
      const sum = sortedArray[fixedYIndex] + sortedArray[fixedZIndex];

      if(sum == target) {
        triplets.push([ fixedX, sortedArray[fixedYIndex], sortedArray[fixedZIndex]]);
        fixedYIndex++;
        fixedZIndex--
      } else if(sum > target) {
        fixedZIndex--;
      } else {
        fixedYIndex++;
      }
    }

  }

  return triplets;
};

console.log(threeSum([-1,0,1,2,-1,-4]));
