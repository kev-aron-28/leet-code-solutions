function isValid(s: string): boolean {
  if(s.length < 2) return false;
  
  const stack: string[] = [];
  const sArr = s.split('');
  
  const pairs: Record<string, string> = {
    '(': ')',
    '[': ']',
    '{': '}'
  }
  
  for(const term of sArr) {
    if(term == '{' || term == '[' || term == '(') {
      stack.push(term)
    } else {
      const top = stack.pop();
      if (!top || pairs[top] !== term) return false;
    }
  }
  
  
  
  return stack.length == 0;
};
