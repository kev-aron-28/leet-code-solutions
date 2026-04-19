package backtracking;

import java.util.Arrays;

public class LetterTilesPossibilities {
    public int solution(String tiles) {
        char letters[] = tiles.toCharArray();
        Arrays.sort(letters);
        boolean used[] = new boolean[letters.length];

        return dfs(letters, used);
    }

    private int dfs(char letters[], boolean used[]) {
        int count = 0;

        for(int i = 0; i < letters.length; i++) {

            if(used[i]) continue;

            if(i > 0 && letters[i] == letters[i - 1] && !used[i - 1]) continue;

            used[i] = true;

            count += 1;
            count += dfs(letters, used);

            used[i] = false;
        }

        return count;
    }
}
