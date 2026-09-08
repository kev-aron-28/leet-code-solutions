public class MultiplyStrings {
    public String solution(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int result[] = new int[num1.length() + num2.length()];

        for(int i = num1.length() - 1; i >= 0; i--) {
            for(int j = num2.length() - 1; j >= 0; j--) {
                int n1 = num1.charAt(i) - '0';
                int n2 = num2.charAt(j) - '0';

                int product = n1 * n2;

                int low = i + j + 1;
                int high = i + j;

                int sum = product + result[low];

                result[low] = sum % 10;
                result[high] += sum / 10;
            }
        }

        StringBuilder s = new StringBuilder();

        for(int n : result) {
            if(s.length() == 0 && n == 0) continue;

            s.append(n);
        } 

        return s.toString();
    }
}
