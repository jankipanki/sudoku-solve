package sudoku;

public class SmallestNumber {

    public String findMin(int[][] board) {

        int minElement = 27;
        int minRow = 0;
        int minColumn = 0;
        int row, column;

        for (row = 0; row < SudokuSolve.SIZE; row++) {
            for (column = 0; column < SudokuSolve.SIZE; column++) {
                if (board[row][column] < minElement & board[row][column] > 0) {
                    minElement = board[row][column];
                    minRow = row;
                    minColumn = column;
                }
            }
        }
        return minRow + "," + minColumn;
    }
}