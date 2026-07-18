package bitmanipulation;

public class NumberOf1Bits {
    public int solution(int n) {
        int x = n;
        int count = 0;
        while(x != 0) {
            x &= (x - 1);
            count++;
        }

        return count;
    }
}
