package ReverseInteger-7;

class Solution {
    public int reverse(int x) {
        int result = 0;

        int number = x;

        while(number != 0) {
            int digit = number % 10;

            number /= 10;

            if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE && digit > 7)) {
                return 0;
            }

            if(result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE && digit < -8)) {
                return 0;
            }

            result = result * 10 + digit;
        }

        return result;
    } 
}