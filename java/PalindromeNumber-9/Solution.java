class Solution {
    public boolean isPalindrome(int x) {
        int number = x;
        int reversed = 0;

        while(number > 0) {
            int rightMost = number % 10;
            number /= 10;
            reversed =  reversed * 10 + rightMost;
        }
        
        return x == reversed;
    }
}