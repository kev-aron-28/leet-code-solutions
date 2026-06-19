package review-1.TwoPointers.Medium;

import java.util.Arrays;

public class BoatsToSavePeople {
    public int solution(int[] people, int limit) {
        int boats = 0;

        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;


        while (left <= right) { 
            if(people[left] + people[right] > limit) {
                boats++;
                right--;
            } else {
                boats++;
                left++;
                right--;
            }
        }

        return boats;
    }
}
