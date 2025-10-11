# Palindrome number

Given an integer x, return true if x is a palindrome, and false otherwise.

Copy the original number → so we can compare later.

Reverse the digits using modulo (% 10) to get the last digit and integer division (/ 10) to remove it.

Build the reversed number: reversed = reversed * 10 + lastDigit.

Compare the reversed number with the original → if they match, it’s a palindrome.