#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>
#include <limits.h>

// Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.

// The algorithm for myAtoi(string s) is as follows:

// Whitespace: Ignore any leading whitespace (" ").
// Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
// Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
// Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
// Return the integer as the final result.

int myAtoi(char* s) {
  int8_t size = strlen(s);

  int32_t number_so_far = 0;

  size_t i = 0;

  int sign = 1;

  while(s[i] == ' ') {
    i++;
  }

  while(s[i] == '+' || s[i] == '-') {
    sign = (s[i] == '-') ? -1 : 1; 
    
    i++;
  }

  while(s[i] >= '0' && s[i] <= '9') {
    char digit = s[i];

    if(number_so_far > INT32_MAX) {
      return sign ? INT_MAX : INT_MIN;
    }

    number_so_far = number_so_far * 10 + (digit - '0');

    i++;
  }
  
  return number_so_far * sign;
}

int main(int argc, char const *argv[])
{
  char * test = "+-12";

  printf("RESULT %d \n", myAtoi(test));

  return 0;
}

