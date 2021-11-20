package sudoku;

public class SudokuSolve {
    public static final int SIZE = 9;
    public static final int EMPTY = 0;

    SudokuConditions conditions = new SudokuConditions();


    public boolean solve(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                //szukamy pustej komórki
                if (board[row][column] == EMPTY) {
                    //szukamy możliwych cyfr
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
            }
        }
        return true; //rozwiązanie
    }
}
