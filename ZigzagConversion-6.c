#include <stdio.h>
#include <stdlib.h>
#include <string.h>


// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

// // P   A   H   N
// // A P L S I I G
// // Y   I   R
// // And then read line by line: "PAHNAPLSIIGYIR"

// // Write the code that will take a string and make this conversion given a number of rows:

// // string convert(string s, int numRows);


char* convert(char* s, int numRows) {
  if(numRows == 1) return s;
  
  enum directions {
    UP = 0,
    DOWN = 1
  };

  int size = strlen(s);

  char * result = (char * )malloc((size + 1) * sizeof(char));

  char * rows[numRows];

  int i = 0;

  for (i = 0; i < numRows; i++)
  {
    rows[i] = (char *)malloc((size + 1) * sizeof(char));

    rows[i][0] = '\0';
  }

  int current_row = 0;

  enum directions direction = DOWN;

  for (i = 0; i < size; i++)
  {
    strncat(rows[current_row], &s[i], 1);

    if(current_row == 0) direction = DOWN;
    
    if(current_row == (numRows - 1)) direction = UP;
    
    if(direction == DOWN) current_row++;
    else current_row--;
  }

  result[0] = '\0';
  
  for(i = 0; i < numRows; ++i ) {
    strcat(result, rows[i]);

    free(rows[i]);
  }
  
  return result;
}

int main(int argc, char const *argv[])
{
  char * test = "PAYPALISHIRING";

  printf("TEST: %s \n RESULT: %s", test, convert(test, 3));
  
  return 0;
}
