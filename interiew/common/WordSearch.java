package common;

public class WordSearch {
    public boolean solution(char board[][], String word) {
        int rows = board.length;
        int cols = board[0].length;

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(canForm(board, r, c, word, 0)) return true;
            }
        }

        return false;
    }
    
    public boolean canForm(char board[][], int row, int col, String word, int index) {

        if(index == word.length()) return true;

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || word.charAt(index) != board[row][col]) {
            return false;
        }

        char temp = board[row][col];

        board[row][col] = '#';

        boolean found = 
            canForm(board, row + 1, col, word, index  + 1) ||
            canForm(board, row - 1, col, word, index + 1)  ||
            canForm(board, row, col + 1, word, index  + 1) ||
            canForm(board, row, col - 1, word, index + 1);

        board[row][col] = temp;

        return found;
    }
}
