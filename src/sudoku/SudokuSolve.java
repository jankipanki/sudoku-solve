package sudoku;

public class SudokuSolve {
    public static final int SIZE = 9;
    public static final int EMPTY = 0;

    SudokuConditions conditions = new SudokuConditions();
    SudokuSmallestNumber ssn = new SudokuSmallestNumber();

    public boolean solve(int[][] board) {

        String smallestNumber = ssn.ssn(board);
        String[] smallestNumberArray = smallestNumber.split(",");
        int row = Integer.parseInt(smallestNumberArray[0]);
        int column = Integer.parseInt(smallestNumberArray[1]);

        if (board[row][column] == EMPTY) {
            for (int number = 1; number <= SIZE; number++) {
                if (conditions.isOk(board, row, column, number)) {
                    board[row][column] = number;

                    if (solve(board)) { //backtracking (algorytm z nawrtotami) rekurencyjnie
                        return true;
                    } else { // jeśli nie jest rozwiązaniem to opróżniamy komórkę i kontynujemy
                        board[row][column] = EMPTY;
                    }
                }
            }
            return false;
        }
        return true; //rozwiązanie
    }
}
