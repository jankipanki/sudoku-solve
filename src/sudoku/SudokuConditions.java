package sudoku;

public class SudokuConditions {

    //sprawdzamy czy jest możliwa cyfra w kolumnie
    public boolean isInRow(int[][] board, int row, int number) {
        for (int i = 0; i < SudokuSolve.SIZE; i++) {
            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    //sprawdzamy czy jest możliwa cyfra w kolumnie
    public boolean isInColumn(int[][] board, int column, int number) {
        for (int i = 0; i < SudokuSolve.SIZE; i++) {
            if (board[i][column] == number) {
                return true;
            }
        }
        return false;
    }

    //sprawdzamy czy jest możliwa cyfra w kwadracie 3x3
    public boolean isInBox(int[][] board, int row, int column, int number) {
        int r = row - row % 3;
        int c = column - column % 3;

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    //łączona metoda do sprawdzenia wszystkich trzech możliwośći
    public boolean isOk(int[][] board, int row, int column, int number) {
        return !isInRow(board, row, number) && !isInColumn(board, column, number) && !isInBox(board, row, column, number);
    }
}