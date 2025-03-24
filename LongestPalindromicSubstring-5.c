#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int expand_around_center(char * string, int l, int r) {
  int left = l;
  int right = r;
  
  while(left >= 0 && right < strlen(string) && string[left] == string[right]) {
    left--;
    right++;
  }

  int len = right - left - 1;

  return len;
}

char* longestPalindrome(char* s) {
  int start = 0, end = 0;

  for(size_t i = 0; i < strlen(s); i++) {
    int odd_len = expand_around_center(s, i, i);
    
    int even_len = expand_around_center(s, i, i + 1);

    int new_len = odd_len > even_len ? odd_len : even_len;

    int old_len = end - start;

    if(new_len > old_len) {
      start = i - (new_len - 1) / 2;

      end = i + new_len / 2;
    }
  }

  char * result = (char *)malloc((end - start + 1) * sizeof(char));

  strncpy(result, s + start, end - start + 1);
  
  result[end - start + 1] = '\0';
  
  return result;
}



int main(int argc, char const *argv[])
{
  char * test = "cbbd";

  printf("RESULT %s \n" , longestPalindrome(test));
  
  return 0;
}
