import java.util.Scanner;

public class Sudoku {
    public static void main(String[] args) {
        // int [][] su = {
        //                 {5, 3, 0, 0, 7, 0, 0, 0, 0},
        //                 {6, 0, 0, 1, 9, 5, 0, 0, 0},
        //                 {0, 9, 8, 0, 0, 0, 0, 6, 0},
        //                 {8, 0, 0, 0, 6, 0, 0, 0, 3},
        //                 {4, 0, 0, 8, 0, 3, 0, 0, 1},
        //                 {7, 0, 0, 0, 2, 0, 0, 0, 6},
        //                 {0, 6, 0, 0, 0, 0, 2, 8, 0},
        //                 {0, 0, 0, 4, 1, 9, 0, 0, 5},
        //                 {0, 0, 0, 0, 8, 0, 0, 7, 9}
        // };
        // if (solveSudoku(su)) {
        //     printSudoku(su);
        // } else {
        //     System.out.println("No solution exists");
        // }

        int[][] su = new int[9][9];
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the Sudoku puzzle (9 rows, each row with 9 numbers separated by spaces, use 0 for empty cells):");
        for (int i = 0; i < 9; i++) {
            System.out.print("Enter row " + (i + 1) + ": ");
            for (int j = 0; j < 9; j++) {
                su[i][j] = scanner.nextInt();
            }
        }

        if (solveSudoku(su)) {
            System.out.println("Solved Sudoku puzzle:");
            printSudoku(su);
        } else {
            System.out.println("No solution exists");
        }

        scanner.close();
    }
    
    static boolean isSafe(int[][] su, int row, int col, int num){
        for (int i = 0; i < su.length; i++) {
            if (su[i][col] == num) {
                return false;
            }
            if (su[row][i] == num) {
                return false;
            }
        }

        // for grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (su[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
    static boolean helper(int[][] su, int row, int col){
        if (row == su.length) {
            return true;
        }

        int nrow = row;
        int ncol = col + 1;
        if (col == su.length - 1) {
            nrow = row + 1;
            ncol = 0;
        }
        
        if (su[row][col] != 0) {
            return helper(su, nrow, ncol);
            }
            
                for (int i = 1; i <= 9; i++) {
                    if (isSafe(su, row, col, i)) {
                        su[row][col] = i;
                        if (helper(su, nrow, ncol)) {
                            return true;
                        } else{
                            su[row][col] = 0;
                        }
                    }
                }
            
        
        return false;
    }
    static boolean solveSudoku(int[][] su){
        return helper(su, 0, 0);
    }
    static void printSudoku(int[][] su) {
        for (int i = 0; i < su.length; i++) {
            for (int j = 0; j < su[i].length; j++) {
                System.out.print(su[i][j] + " ");
            }
            System.out.println();
        }
    }
}
