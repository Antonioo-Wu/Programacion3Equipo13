package clase13.Actividad1;

public class SudokuSolver {
    // Tamaño del tablero
    private static final int SIZE = 6;

    // Método principal que llama a la función de resolución
    public static void main(String[] args) {
        int[][] board = {
            {1, 0, 0, 4, 5, 0},
            {0, 5, 0, 6, 0, 2},
            {2, 0, 0, 0, 3, 0},
            {0, 0, 5, 0, 0, 1},
            {0, 6, 0, 0, 0, 4},
            {4, 3, 0, 1, 0, 0}
        };

        if (solveSudoku(board)) {
            printBoard(board);
        } else {
            System.out.println("No existe solución para este Sudoku.");
        }
    }

    // Método que resuelve el Sudoku usando backtracking
    public static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {  // Encuentra una celda vacía
                    for (int num = 1; num <= SIZE; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            // Recursivamente intenta resolver el tablero
                            if (solveSudoku(board)) {
                                return true;
                            }

                            // Deshacer el intento si falla
                            board[row][col] = 0;
                        }
                    }
                    return false;  // Si ningún número es válido, retrocede
                }
            }
        }
        return true;  // El tablero está completo y es válido
    }

    // Método para verificar si un número puede ser colocado en una posición
    private static boolean isValid(int[][] board, int row, int col, int num) {
        // Verificar si el número está en la fila
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // Verificar si el número está en la columna
        for (int i = 0; i < SIZE; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Verificar si el número está en el subcuadro 2x3
        int startRow = (row / 2) * 2;
        int startCol = (col / 3) * 3;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }

        return true;  // Si pasa todas las pruebas, es válido
    }

    // Método para imprimir el tablero
    private static void printBoard(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
}
