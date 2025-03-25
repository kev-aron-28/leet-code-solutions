#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <limits.h>
#include <stdint.h>

bool isPalindrome(int x) {
  int reversed_number = 0;

  int number_to_reverse = x;

  if(x < 0) return false;

  while(number_to_reverse != 0) {
    int digit = number_to_reverse % 10;

    number_to_reverse /= 10;

    if(reversed_number > (INT32_MAX / 10) || (reversed_number == INT32_MAX / 10)) {
      return 0;
    }

    if(reversed_number < (INT32_MIN / 10) || (reversed_number == INT32_MIN / 10)) {
      return 0;
    }

    reversed_number = reversed_number * 10 + digit;
  }

  return reversed_number == x ? true : false;
}

int main(int argc, char const *argv[])
{
  int test = 12;

  printf("IS EQUAL %d \n", isPalindrome(test));

  return 0;
}
