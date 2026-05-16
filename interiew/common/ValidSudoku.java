package common;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char board[][]) {
        Set<String> seen = new HashSet<>();

        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                char value = board[row][col];

                if(value == '.') continue;
                
                if (
                    !seen.add(value + "in row" + row) ||
                    !seen.add(value + "in col" + col) ||
                    !seen.add(value + "in box" + (row / 3) + "-" + (col / 3))
                ) {
                    return false;
                }
            }
        }

        return true;
    }
}
