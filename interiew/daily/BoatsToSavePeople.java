package daily;

import java.util.Arrays;

public class BoatsToSavePeople {
    public int solution(int people[], int limit) {
        int count = 0;

        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        while (left <= right) { 
            if(people[left] + people[right] > limit) {
                count++;
                right--;
            } else {
                count++;
                left++;
                right--;
            }
        }

        return count;
    }
}
