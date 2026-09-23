
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    public List<List<Integer>> solution(int arr[]) {
        Arrays.sort(arr);

        List<List<Integer>> result = new ArrayList<>();

        int diff = Integer.MAX_VALUE;

        for(int i = 1; i < arr.length; i++) {
            diff = Math.min(diff, arr[i] - arr[i - 1]);
        }

        for(int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) == diff) {
                List<Integer> temp = new ArrayList<>();

                temp.add(arr[i - 1]);
                temp.add(arr[i]);

                result.add(temp);
            }
        }
        
        return result;
    }
}
