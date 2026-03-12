package random;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ClimbingtheLeaderboard {
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        Set<Integer> rank = new LinkedHashSet<>();

        for(int score : ranked) {
            rank.add(score);
        }

        List<Integer> noDuplicates = new ArrayList<>(rank);
        List<Integer> result = new ArrayList<>();
        int j = noDuplicates.size() - 1;
        for(int number : player) {

            while(j >= 0 && number >= noDuplicates.get(j) ) {
                j--;
            }

            result.add(j + 2);
        }

        return result;
    }

    public static void main(String[] args) {
        climbingLeaderboard(List.of(100,90,90,80,70), List.of(70,80,90,200));
    }
}
