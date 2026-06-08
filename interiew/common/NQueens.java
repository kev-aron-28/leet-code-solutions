package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {

    private Set<Integer> cols = new HashSet<>();
    private Set<Integer> diagonal = new HashSet<>();
    private Set<Integer> antiDiag = new HashSet<>();

    public List<List<String>> solution(int n){
        List<List<String>> result = new ArrayList<>();
        
        char board[][] = new char[n][n];

        for(int r = 0; r < n; r++) {
            Arrays.fill(board[r], '.');
        }

        formBoard(board, 0, result);

        return result;
    }

    private void formBoard(char board[][], int row, List<List<String>> result) {
        if(row == board.length) {
            List<String> solution = new ArrayList<>();

            for(char r[] : board) {
                solution.add(new String(r));
            }

            result.add(solution);

            return;
        }

        for(int col = 0; col < board[0].length; col++) {
            if(cols.contains(col) || diagonal.contains(row - col) || antiDiag.contains(row + col)){
                continue;
            }

            board[row][col] = 'Q';
            cols.add(col);
            diagonal.add(row - col);
            antiDiag.add(row + col);

            formBoard(board, row + 1, result);

            board[row][col] = '.';

            cols.remove(col);
            diagonal.remove(row - col);
            antiDiag.remove(row + col);
        }
    }
}
