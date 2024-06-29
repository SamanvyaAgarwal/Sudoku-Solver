# Sudoku-Solver
*This project implements a Sudoku solver in Java. The key component of the solver is the **helper** method, which uses backtracking to fill in the Sudoku grid. Below is a detailed explanation of the helper method:*
## helper Method
*The **'helper'** method is a recursive function that attempts to solve the Sudoku puzzle by filling in the empty cells.*
### Parameters
![This is an alt text.](/![image](https://github.com/SamanvyaAgarwal/Sudoku-Solver/assets/149570345/ffbe93ed-f674-45ec-a658-c8c28b28ea29)
 "This is a sample image.")
* **'int[][] su'**: *The Sudoku grid represented as a 2D array.* 
* **'int row'**: *The current row index.*
*  **'int col'**: *The current column index.*
### Logic
1. **Base case:**
* *If the **'row'** index reaches the length of the Sudoku grid, it means we have processed all rows and the puzzle is solved, so the method returns **'true'**.*
2. **Determine Next Cell:**
* *The next cell to process is typically the next column in the same row (**'col + 1'**).*
* *If the current column is the last column in the row (**'col == su.length - 1'**), the next cell is the first column of the next row (**'nrow = row + 1, ncol = 0'**).*
3. **Skip Filled Cells:**
* *If the current cell is already filled (i.e., not **'0'**), the method recursively calls itself with the next cell (**'nrow, ncol'**).*
4. **Try Possible Numbers:**
* *The method tries all possible numbers (**'1'** to **'9'**) for the current cell.*
* *It checks if placing the number **'i'** in the current cell is safe using the **'isSafe'** method.*
* *If placing the number **'i'** is safe, it assigns the number to the cell and recursively calls the **'helper'** method with the next cell (**'nrow, ncol'**).*
* *If the recursive call returns **'true'**, it means the puzzle is solved, and the method returns **'true'**.*
* *If the recursive call returns **'false'**, it resets the cell to **'0'** (backtracks) and tries the next number.*
5. **Backtracking:**
* *If no number from **'1'** to **'9'** can be placed in the current cell, the method returns **'false'**, indicating that the current path does not lead to a solution.*
