package sudoku;

public class SudokuPrint {
    public void display(int[][] board) {
        for (int i = 0; i < SudokuSolve.SIZE; i++) {
            for (int j = 0; j < SudokuSolve.SIZE; j++) {
                System.out.print("\t" + board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
