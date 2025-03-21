#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <limits.h>

int reverse(int x){
  int reversed_number = 0;

  int number_to_reverse = x;

  while(number_to_reverse != 0) {
    int32_t digit = number_to_reverse % 10;

    number_to_reverse /= 10;

    if(reversed_number > (INT32_MAX / 10) || (reversed_number == INT32_MAX / 10)) {
      return 0;
    }

    if(reversed_number < (INT32_MIN / 10) || (reversed_number == INT32_MIN / 10)) {
      return 0;
    }

    reversed_number = reversed_number * 10 + digit;
  }

  return reversed_number;
}

int main(int argc, char const *argv[])
{
  int32_t test = 1534236469;

  printf("TEST %d", reverse(test));

  return 0;
}

