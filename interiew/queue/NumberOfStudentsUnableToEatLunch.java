package queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class NumberOfStudentsUnableToEatLunch {
    public int solution(int students[], int sandwiches[]) {
        int count[] = new int[2];

        for(int s : students) {
            count[s]++;
        }

        for (int s : sandwiches) {
            if(count[s] == 0) {
                break;
            }

            count[s]--;
        }

        return count[0] + count[1];
    }
}
