package random;

import java.util.ArrayList;
import java.util.List;

public class ClimbingtheLeaderboard {
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> result = new ArrayList<>();

        int currentRank = 1;

        for(int i = 1; i < ranked.size(); i++) {
            if(!ranked.get(i).equals(ranked.get(i - 1))) currentRank++; 
        }

        
        for(int number : player) {
            int j = ranked.size() - 1;

            while(j >= 0 && ) {

            }
        }

        return result;
    }

    public static void main(String[] args) {
        climbingLeaderboard(List.of(100,90,90,80,70), List.of(70,80,90,200));
    }
}
