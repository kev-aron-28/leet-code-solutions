package marathons.backtracking-1;

import java.util.Arrays;

public class LetterTilePossibilities {
    public int solution(String tiles) {
        char letters[] = tiles.toCharArray();

        Arrays.sort(letters);

        boolean used[] = new boolean[letters.length];

        return permutations(letters, used);
    }

    private int permutations(char[] letters, boolean[] used) {
        int count = 0;

        for(int i = 0; i < letters.length; i++) {
            if(used[i]) continue;

            if(i > 0 && letters[i] == letters[i - 1] && !used[i - 1]) continue;

            used[i] = true;

            count++;
            count += permutations(letters, used);

            used[i] = false;
        }

        return count;
    }
}
