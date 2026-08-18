package marathons.backtracking-1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {
    Set<Integer> cols = new HashSet<>();
    Set<Integer> diagonal = new HashSet<>();
    Set<Integer> antiDiagonal = new HashSet<>();
    List<List<String>> result = new ArrayList<>();
    
    public List<List<String>> solutino(int n) {
        char [][] board = new char[n][n];

        for(int r = 0; r < n; r++) {
            Arrays.fill(board[r], '.');
        }

        nqueens(0, board);
    
        return result;
    }

    private void nqueens(int row, char[][] board) {
        if(row == board.length) {
            List<String> sol = new ArrayList<>();

            for(char r[] : board) {
                sol.add(new String(r));
            }

            result.add(sol);

            return;
        }

        for(int col = 0; col < board[0].length; col++) {
            int d = row - col;
            int a = row + col;

            if(cols.contains(col) || diagonal.contains(d) || antiDiagonal.contains(a)) {
                continue;
            }

            board[row][col] = 'Q';
            cols.add(col);
            diagonal.add(d);
            antiDiagonal.add(a);

            nqueens(row + 1, board);
            
            board[row][col] = '.';
            cols.remove(col);
            diagonal.remove(d);
            antiDiagonal.remove(a);
        }
    } 
}
