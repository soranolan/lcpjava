package com.example.lcpjava.array;

public class Lcp_59_Spiral_Matrix_II {
	
	/**
	 * time  : O(n ^ 2)
	 * space : O(1)
	 * 
	 * int[][] matrix <- new int[n][n]
	 * 
	 * int max <- n times n
	 * int number <- 1
	 * int row <- 0
	 * int col <- 0
	 * int rows <- n
	 * int cols <- n
	 * 
	 * while number is lower than or equal to max
	 * 		for int i <- col; if i is lower than cols; i++
	 * 			matrix[row][i] <- number
	 * 			number++
	 * 		end for
	 * 		
	 * 		if number is greater than max
	 * 			break
	 * 		end if
	 * 		
	 * 		for int i <- row plus one; if i is lower than rows minus one; i++
	 * 			matrix[i][cols minus one] <- number
	 * 			number++
	 * 		end for
	 * 		
	 * 		if number is greater than max
	 * 			break
	 * 		end if
	 * 		
	 * 		for int i <- cols minus one; if i is greater than or equal to col; i--
	 * 			matrix[rows minus one][i] <- number
	 * 			number++
	 * 		end for
	 * 		
	 * 		if number is greater than max
	 * 			break
	 * 		end if
	 * 		
	 * 		for int i <- rows minus two; if i is greater than row; i--
	 * 			matrix[i][col] <- number
	 * 			number++
	 * 		end for
	 * 		
	 * 		if number is greater than max
	 * 			break
	 * 		end if
	 * 		
	 * 		row++
	 * 		col++
	 * 		rows--
	 * 		cols--
	 * end while
	 * 
	 * return matrix
	 * */
	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];																				// S : O(n ^ 2)
		
		int max = n * n;
		int number = 1;
		int row = 0;
		int col = 0;
		int rows = n;
		int cols = n;
		
		while (number <= max) {																						// T : O(n ^ 2)
			// ¡÷
			for (int i = col; i < cols; i++) { matrix[row][i] = number++; }
			if (number > max) { break; }
			
			// ¡õ
			for (int i = row + 1; i < rows - 1; i++) { matrix[i][cols - 1] = number++; }
			if (number > max) { break; }
			
			// ¡ö
			for (int i = cols - 1; i >= col; i--) { matrix[rows - 1][i] = number++; }
			if (number > max) { break; }
			
			// ¡ô
			for (int i = rows - 2; i > row; i--) { matrix[i][col] = number++; }
			if (number > max) { break; }
			
			row++;
			col++;
			rows--;
			cols--;
		}
		
		return matrix;
	}
	
}
