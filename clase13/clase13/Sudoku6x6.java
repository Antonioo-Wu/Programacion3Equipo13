

import java.util.Random;

public class Sudoku6x6 {
    private static final int SIZE = 6; // Tamaño del tablero 6x6
    private static final int SUBGRID_SIZE = 2; // Subcuadrantes 2x3
    private static final int EMPTY = 0; // Valor para las celdas vacías
    private int[][] board;

    public Sudoku6x6() {
        board = new int[SIZE][SIZE];
    }

    // Método principal para generar un tablero de Sudoku
    public void generateSudoku() {
        fillBoard(); // Llena el tablero con una solución completa
        removeNumbers(); // Elimina algunos números para crear el desafío
    }

    private boolean fillBoard() {
        // Recorre cada fila del tablero
        for (int row = 0; row < SIZE; row++) {
            // Recorre cada columna del tablero
            for (int col = 0; col < SIZE; col++) {
                // Si la celda está vacía
                if (board[row][col] == EMPTY) {
                    // Intenta colocar los números del 1 al 6 en la celda
                    for (int num = 1; num <= SIZE; num++) {
                        // Verifica si el número es válido en la posición (row, col)
                        if (isValid(row, col, num)) {
                            // Coloca el número en la celda
                            board[row][col] = num;
                            // Llama recursivamente para llenar el siguiente espacio
                            if (fillBoard()) {
                                return true; // Si se completa el tablero, retorna true
                            }
                            // Si no puede completar, vacía la celda (backtracking)
                            board[row][col] = EMPTY;
                        }
                    }
                    return false; // Retrocede si no puede colocar ningún número válido
                }
            }
        }
        return true; // Si todas las celdas están llenas, retorna verdadero
    }
    

    // Verifica si un número es válido en una posición dada
    private boolean isValid(int row, int col, int num) {
        // Verifica si el número ya está en la fila
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // Verifica si el número ya está en la columna
        for (int i = 0; i < SIZE; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Verifica si el número ya está en el subcuadrante
        int subGridRow = (row / SUBGRID_ROWS) * SUBGRID_ROWS; // Calcula la fila inicial del subcuadrante
        int subGridCol = (col / SUBGRID_COLS) * SUBGRID_COLS; // Calcula la columna inicial del subcuadrante
        for (int i = 0; i < SUBGRID_ROWS; i++) {
            for (int j = 0; j < SUBGRID_COLS; j++) {
                if (board[subGridRow + i][subGridCol + j] == num) {
                    return false;
                }
            }
    }

        return true; // El número es válido en la posición dada
    }


    /// Elimina algunos números para crear el rompecabezas
    private void removeNumbers() {
        Random rand = new Random(); // Crea una instancia de Random
        int cellsToRemove = 12 + rand.nextInt(6); // Elige aleatoriamente entre 12 y 18 celdas para vaciar

        while (cellsToRemove > 0) {
            int row = rand.nextInt(SIZE); // Selecciona una fila aleatoria
            int col = rand.nextInt(SIZE); // Selecciona una columna aleatoria

            if (board[row][col] != EMPTY) {
                board[row][col] = EMPTY; // Vacía la celda seleccionada
                cellsToRemove--; // Decrementa el contador de celdas por eliminar
            }
        }
    }


    // Imprime el tablero en la consola
    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    System.out.print(". ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Sudoku6x6 sudoku = new Sudoku6x6();
        sudoku.generateSudoku();
        sudoku.printBoard(); // Muestra el tablero generado
    }
    
}