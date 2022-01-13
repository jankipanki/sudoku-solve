package sudoku;

public class SudokuApp {
    public static void main(String[] args) {
        SudokuPrint sp = new SudokuPrint();
        SudokuSolve ss = new SudokuSolve();

        int[][] GRID_TO_SOLVE = {
                {0, 0, 5, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 9, 0, 0, 0},
                {0, 8, 0, 4, 6, 0, 0, 3, 0},
                {0, 4, 0, 3, 7, 0, 0, 6, 0},
                {0, 0, 0, 2, 0, 0, 0, 0, 0},
                {8, 0, 0, 0, 0, 0, 4, 0, 0},
                {0, 7, 0, 0, 0, 2, 0, 0, 0},
                {1, 0, 0, 7, 9, 0, 0, 0, 3},
                {0, 0, 0, 0, 0, 8, 0, 9, 0},
        };

        System.out.println("PROGRAM DO ROZWIAZYWANIA SUDOKU");
        sp.display(GRID_TO_SOLVE);

        if (ss.solve(GRID_TO_SOLVE)) {
            System.out.println("Udało się - sudoku zostało rozwiazane.");
            sp.display(GRID_TO_SOLVE);
        } else {
            System.err.println("Niestety... sudoku nierozwiązano.");
        }
    }
}