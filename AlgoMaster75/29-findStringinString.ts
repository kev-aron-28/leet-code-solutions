function strStr(haystack: string, needle: string): number {
  let start = 0;
  let lenOfWord = needle.length;
  
  while(start <= haystack.length - lenOfWord) {
    if(haystack[start] === needle[0]) {
      let end = start;
      let currenIndex = 0;
      
      while(currenIndex < lenOfWord && haystack[end] == needle[currenIndex]) {
        end++;
        currenIndex++
      }
      
      if(currenIndex == lenOfWord) return start;
    }
    
    start++;
  }
  
  return -1;
};
