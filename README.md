# Sudoku-Solver
*This project implements a Sudoku solver in Java. The key component of the solver is the **helper** method, which uses backtracking to fill in the Sudoku grid. Below is a detailed explanation of the helper method:*
## helper Method
*The **'helper'** method is a recursive function that attempts to solve the Sudoku puzzle by filling in the empty cells.*
### Parameters
* **'int[][] su'**: *The Sudoku grid represented as a 2D array.* 
* **'int row'**: *The current row index.*
*  **'int col'**: *The current column index.*
### Logic
1. **Base case:**

    ![Screenshot 2024-06-29 140000](https://github.com/SamanvyaAgarwal/Sudoku-Solver/assets/149570345/31b77796-8b04-40e6-866c-195753e471b9)
* *If the **'row'** index reaches the length of the Sudoku grid, it means we have processed all rows and the puzzle is solved, so the method returns **'true'**.*
2. **Determine Next Cell:**

    ![Screenshot 2024-06-29 140441](https://github.com/SamanvyaAgarwal/Sudoku-Solver/assets/149570345/9221db7a-44bb-43f5-9649-852067bd97e4)

* *The next cell to process is typically the next column in the same row (**'col + 1'**).*
* *If the current column is the last column in the row (**'col == su.length - 1'**), the next cell is the first column of the next row (**'nrow = row + 1, ncol = 0'**).*
3. **Skip Filled Cells:**

    ![Screenshot 2024-06-29 140618](https://github.com/SamanvyaAgarwal/Sudoku-Solver/assets/149570345/a5fca0d5-6fe6-4f8a-96da-148bb7ba5fd5)

* *If the current cell is already filled (i.e., not **'0'**), the method recursively calls itself with the next cell (**'nrow, ncol'**).*
4. **Try Possible Numbers:**

    ![Screenshot 2024-06-29 140730](https://github.com/SamanvyaAgarwal/Sudoku-Solver/assets/149570345/bbb55ce8-0678-40aa-81bf-3e167491d702)

* *The method tries all possible numbers (**'1'** to **'9'**) for the current cell.*
* *It checks if placing the number **'i'** in the current cell is safe using the **'isSafe'** method.*
* *If placing the number **'i'** is safe, it assigns the number to the cell and recursively calls the **'helper'** method with the next cell (**'nrow, ncol'**).*
* *If the recursive call returns **'true'**, it means the puzzle is solved, and the method returns **'true'**.*
* *If the recursive call returns **'false'**, it resets the cell to **'0'** (backtracks) and tries the next number.*
5. **Backtracking:**

    ![Screenshot 2024-06-29 140808](https://github.com/SamanvyaAgarwal/Sudoku-Solver/assets/149570345/b04156b8-932d-4ee5-987f-88dedcdc305b)

* *If no number from **'1'** to **'9'** can be placed in the current cell, the method returns **'false'**, indicating that the current path does not lead to a solution.*


## isSafe Method 
*The **'isSafe'** method checks if placing a given number in a specific cell of the Sudoku grid is allowed according to the rules of Sudoku.*
### Parameters
* **'int[][] su'**: *The Sudoku grid represented as a 2D array.* 
* **'int row'**: *The current row index.*
*  **'int col'**: *The current column index.*
*  **'int num'**: *The number to check if it can be placed in the cell.*
### Logic
1. **Check Row and Column:**

    ![Screenshot 2024-06-29 141844](https://github.com/SamanvyaAgarwal/Sudoku-Solver/assets/149570345/16708e4a-6972-4037-9557-222136f9251c)

* *Iterate through each element in the same column (**'su[i][col]'**) and same row (**'su[row][i]'**).*
* *If the number **'num'** is found in the same row or column, return **'false'**.*
2. **Check 3x3 Subgrid:**

    ![Screenshot 2024-06-29 141924](https://github.com/SamanvyaAgarwal/Sudoku-Solver/assets/149570345/d7a3b67c-8a61-4aaa-805b-0a6076a3331d)

* *Calculate the starting row (**'sr'**) and starting column (**'sc'**) of the 3x3 subgrid containing the cell.*
* *Iterate through each cell in the 3x3 subgrid.*
* *If the number **'num'** is found in the subgrid, return **'false'**.*
3. **Return True:**

    ![Screenshot 2024-06-29 142011](https://github.com/SamanvyaAgarwal/Sudoku-Solver/assets/149570345/2857ef0a-6803-4ea1-82ea-39a40de438b0)

* *If the number **'num'** is not found in the same row, column, or 3x3 subgrid, return **'true'**.*
