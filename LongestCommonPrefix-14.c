#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* longestCommonPrefix(char** strs, int strsSize) {
  if (strsSize == 0) return "";

  int i = 0;
    while (strs[0][i]) {
        char current_char = strs[0][i];
        for (int j = 1; j < strsSize; j++) {
            if (strs[j][i] != current_char || strs[j][i] == '\0') {
                char* prefix = (char*)malloc(i + 1);
                strncpy(prefix, strs[0], i);
                prefix[i] = '\0';
                return prefix;
            }
        }
        i++;
    }

  
  char* prefix = (char*)malloc(i + 1);
  
  strcpy(prefix, strs[0]);
  
  return prefix;
}

int main() {
  char* words[] = {"flower", "flow", "flight"};
  int n = sizeof(words) / sizeof(words[0]);

  char* prefix = longestCommonPrefix(words, n);
  printf("Longest common prefix: %s\n", prefix);

  return 0;
}
