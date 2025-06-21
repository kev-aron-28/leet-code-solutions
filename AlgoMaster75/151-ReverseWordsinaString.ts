function reverseWords(s: string): string {
  let reversedWords = "";
  let len = s.length;
  
  let words: string[] = [];
  let buffer = ''
  for(const char of s) {
    
    if(char != ' ') {
      buffer += char;
    } else {
      if(buffer.length > 0) {
        words.push(buffer);
        buffer = ''
      }
    }
  }
  
  if(buffer.length > 0) words.push(buffer);
  
  for(let i = words.length - 1; i >= 0; i--) {
    reversedWords += words[i];
    if(i > 0) reversedWords += ' ';
  }
    
  return reversedWords;
};
