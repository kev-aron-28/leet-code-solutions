public class MissingNumberInArithmeticProgression {
    public int solution(int arr[]) {
        int diff1 = arr[1] - arr[0];
        int diff2 = arr[2] - arr[1];

        int diff = Math.abs(diff1) < Math.abs(diff2) ? diff1 : diff2;

        for(int i = 1; i < arr.length; i++) {
            int currentDiff = arr[i] - arr[i - 1];
            if (currentDiff != diff) {
                return arr[i - 1] + diff;  
            }
        }

        return arr[arr.length - 1] + diff;
    }
}
