#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

// Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

// '.' Matches any single character.​​​​
// '*' Matches zero or more of the preceding element.
// The matching should cover the entire input string (not partial).




// If both the string s and the pattern p are empty, they match.

// If the pattern p is empty but the string s is not, they do not match.

// If the pattern contains *, it may match zero or more characters of the preceding character.

bool isMatch(char * s, char * p) {

  int size_s = strlen(s);

  int size_p = strlen(p);

  bool dp[size_s + 1][size_p + 1];

  dp[0][0] = true;

  for (size_t i = 1; i <= size_p; i++)
  {
    if(p[i - 1] == '*') {
      dp[0][i] = dp[0][i - 2];
    } else {
      dp[0][i] = false;
    }
  }

  for (size_t i = 1; i <= size_s; i++)
  {
    for (size_t j = 1; j <= size_p; j++)
    {
      if(p[j-1] == s[i-1] || p[j - 1] == '.') {
      } 
    }
    
  }
  


  
 
}


int main(int argc, char const *argv[])
{
  char * s = "aa";

  char * p = "a*";
  return 0;
}

