package neetcode150;

public class Pow {
    public double solution(double x, int n) { 
        long exponent = n;

        if (exponent < 0) {
            x = 1 / x;
            exponent = -exponent;
        }

        double result = 1;

        while(exponent > 0){
            if (exponent % 2 == 1) {
                result *= x;
            }

            x *= x;
            exponent /= 2;
        }

        return result;
    }
}
