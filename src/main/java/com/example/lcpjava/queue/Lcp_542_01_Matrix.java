package com.example.lcpjava.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Lcp_542_01_Matrix {
	
	/**
	 * time  : O(m * n)
	 * space : O(m * n)
	 * 
	 * int rows <- matrix length
	 * int cols <- matrix[0] length
	 * Queue<int[]> queue <- new LinkedList
	 * 
	 * for int row <- 0; if row is lower than rows; row++
	 * 		for int col <- 0; if col is lower than cols; col++
	 * 			if matrix[row][col] is equal to zero
	 * 				queue offer(new int array[ row, col ])
	 * 			else
	 * 				matrix[row][col] <- -1
	 * 			end if
	 * 		end for
	 * end for
	 * 
	 * BFS(matrix, queue)
	 * 
	 * return matrix
	 * */
	public int[][] updateMatrix_1(int[][] mat) {
		int rows = mat.length;
		int cols = mat[0].length;
		Queue<int[]> queue = new LinkedList<>();																	// S : O(m * n)
		
		for (int row = 0; row < rows; row++) {																		// T : O(m)
			for (int col = 0; col < cols; col++) {																	// T : O(n)
				if (mat[row][col] == 0) {
					queue.offer(new int[] { row, col });
				} else {
					mat[row][col] = -1;
				}
			}
		}
		
		BFS(mat, queue);
		
		return mat;
	}
	
	/**
	 * int[][] directions <- [ -1, 0 ], [ 1, 0 ], [ 0, -1 ], [ 0, 1 ]
	 * int rows <- matrix length
	 * int cols <- matrix[0] length
	 * 
	 * while queue is not empty
	 * 		int[] coordinate <- queue poll
	 * 		int row <- coordinate[0]
	 * 		int col <- coordinate[1]
	 * 		
	 * 		for	int[] direction in directions
	 * 			int nextRow <- row plus direction[0]
	 * 			int nextCol <- col plus direction[1]
	 * 			
	 * 			if nextRow is lower than zero || nextCol is lower than zero || nextRow is greater than or equal to rows || nextCol is greater than or equal to cols || matrix[row][col] is not equal to minus one
	 * 				continue
	 * 			end if
	 * 			
	 * 			matrix[nextRow][nextCol] <- matrix[row][col] plus one
	 * 			
	 * 			queue offer(new int array[ nextRow, nextCol ])
	 * 		end for
	 * end while
	 * */
	public void BFS(int[][] mat, Queue<int[]> queue) {
		int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		int rows = mat.length;
		int cols = mat[0].length;
		
		while (!queue.isEmpty()) {																					// T : O(m * n)
			int[] coordinate = queue.poll();
			int row = coordinate[0];
			int col = coordinate[1];
			
			for (int[] direction : directions) {
				int nextRow = row + direction[0];
				int nextCol = col + direction[1];
				
				if (nextRow < 0 || nextCol < 0 || nextRow >= rows || nextCol >= cols || mat[nextRow][nextCol] != -1) { continue; }
				
				mat[nextRow][nextCol] = mat[row][col] + 1;
				
				queue.offer(new int[] { nextRow, nextCol });
			}
		}
	}
	
	/**
	 * time  : O(m * n)
	 * space : O(1)
	 * 
	 * int rows <- matrix length
	 * int cols <- matrix[0] length
	 * int max <- rows pllus cols minus two
	 * 
	 * for int row <- 0; if row is lower than rows; row++
	 * 		for int col <- 0; if col is lower than cols; col++
	 * 			if matrix[row][col] is equal to zero
	 * 				continue
	 * 			end if
	 * 			int top <- if row is greater than zero then matrix[row minus one][col] else max
	 * 			int left <- if col is greater than zero then matrix[row][col minus one] else max
	 * 			matrix[row][col] <- Math min(top, left) plus one
	 * 		end for
	 * end for
	 * 
	 * for int row <- rows minus one; if row is greater than or equal to zero; row--
	 * 		for int col <- cols minus one; if col is greater than or equal to zero; col--
	 * 			if matrix[row][col] is equal to zero
	 * 				continue
	 * 			end if
	 * 			int bottom <- if row is lower than rows minus one then matrix[row plus one][col] else max
	 * 			int right <- if col is lower than cols minus one then matrix[row][col plus one] else max
	 * 			matrix[row][col] <- Math min(matrix[row][col], Math min(bottom, right) plus one)
	 * 		end for
	 * end for
	 * 
	 * return matrix
	 * */
	public int[][] updateMatrix_2(int[][] mat) {
		int rows = mat.length;
		int cols = mat[0].length;
		int max = rows + cols - 2;
		
		// top and left
		for (int row = 0; row < rows; row++) {																		// T : O(m)
			for (int col = 0; col < cols; col++) {																	// T : O(n)
				if (mat[row][col] == 0) { continue; }
				int top = (row > 0) ? mat[row - 1][col] : max;
				int left = (col > 0) ? mat[row][col - 1] : max;
				mat[row][col] = Math.min(top, left) + 1;
			}
		}
		
		// bottom right
		for (int row = rows - 1; row >= 0; row--) {																	// T : O(m)
			for (int col = cols - 1; col >= 0; col--) {																// T : O(n)
				if (mat[row][col] == 0) { continue; }
				int bottom = (row < rows - 1) ? mat[row + 1][col] : max;
				int right = (col < cols - 1) ? mat[row][col + 1] : max;
				mat[row][col] = Math.min(mat[row][col], Math.min(bottom, right) + 1);
			}
		}
		
		return mat;
	}
	
	/**
	 * time  : O(m * n)
	 * space : O(1)
	 * 
	 * Data Structure
	 * make processing more efficient for larger arrays by referencing the rows of the array through one-dimensional arrays
	 * 
	 * int lastRow <- matrix length minus one
	 * int lastCol <- matrix[0] length minus one
	 * 
	 * int[] currentRow <- matrix[0]
	 * int[] previousRow <- null
	 * 
	 * if currentRow[0] is equal to one
	 * 		currentRow[0] <- lastRow plus lastCol
	 * end if
	 * 
	 * for int col <- 1; if col is lower than or equal to lastCol; col++
	 * 		if currentRow[col] is equal to zero
	 * 			continue
	 * 		end if
	 * 		currentRow[col] <- currentRow[col minus one] plus one
	 * end for
	 * 
	 * for int row <- 1; if row is lower than or equal to lastRow; row++
	 * 		previousRow <- currentRow
	 * 		currentRow <- matrix[row]
	 * 		
	 * 		if currentRow[0] is equal to one
	 * 			currentRow[0] <- previousRow[0] plus one
	 * 		end if
	 * 		
	 * 		for int col <- 1; if col is lower than or equal to lastCol; col++
	 * 			if currentRow[col] is equal to zero
	 * 				continue
	 * 			end if
	 * 			currentRow[col] <- Math min(currentRow[col minus one], previousRow[col]) plus one
	 * 		end for
	 * end for
	 * 
	 * for int col <- lastCol minus one; if col is greater than or equal to zero; col--
	 * 		if currentRow[col] is lower than or equal to one
	 * 			continue
	 * 		end if
	 * 		currentRow[col] <- Math min(currentRow[col], currentRow[col plus one] plus one)
	 * end for
	 * 
	 * for int row <- lastRow minus one; if row is greater than or equal to zero; row--
	 * 		previousRow <- currentRow
	 * 		currentRow <- matrix[row]
	 * 		
	 * 		if currentRow[lastCol] is greater than one
	 * 			currentRow[lastCol] <- Math min(currentRow[lastCol], previousRow[lastCol] plus one)
	 * 		end if
	 * 		
	 * 		for int col <- lastCol minus one; if col is greater than or equal to zero; col--
	 * 			if currentRow[col] is lower than or equal to one
	 * 				continue
	 * 			end if
	 * 			currentRow[col] <- Math min(currentRow[col], Math min(currentRow[col plus one], previousRow[col]) plus one)
	 * 		end for
	 * end for
	 * 
	 * return matrix
	 * */
	public int[][] updateMatrix(int[][] mat) {
		int lastRow = mat.length - 1;
		int lastCol = mat[0].length - 1;
		
		int[] currentRow = mat[0];
		int[] previousRow = null;
		
		// first cell only
		if (currentRow[0] == 1) { currentRow[0] = lastRow + lastCol; }
		
		// first row except first cell
		for (int col = 1; col <= lastCol; col++) {																	// T : O(n - 1)
			if (currentRow[col] == 0) { continue; }
			currentRow[col] = currentRow[col - 1] + 1;
		}
		
		// second row and other row
		for (int row = 1; row <= lastRow; row++) {																	// T : O(m - 1)
			previousRow = currentRow;
			currentRow = mat[row];
			
			if (currentRow[0] == 1) { currentRow[0] = previousRow[0] + 1; }
			
			for (int col = 1; col <= lastCol; col++) {																// T : O(n - 1)
				if (currentRow[col] == 0) { continue; }
				currentRow[col] = Math.min(currentRow[col - 1], previousRow[col]) + 1;
			}
		}
		
		// last row except last cell
		for (int col = lastCol - 1; col >= 0; col--) {																// T : O(n - 1)
			if (currentRow[col] <= 1) { continue; }
			currentRow[col] = Math.min(currentRow[col], currentRow[col + 1] + 1);
		}
		
		// other row
		for (int row = lastRow - 1; row >= 0; row--) {																// T : O(m - 1)
			previousRow = currentRow;
			currentRow = mat[row];
			
			if (currentRow[lastCol] > 1) {
				currentRow[lastCol] = Math.min(currentRow[lastCol], previousRow[lastCol] + 1);
			}
			
			for (int col = lastCol - 1; col >= 0; col--) {															// T : O(n - 1)
				if (currentRow[col] <= 1) { continue; }
				currentRow[col] = Math.min(currentRow[col], Math.min(currentRow[col + 1], previousRow[col]) + 1);
			}
		}
		
		return mat;
	}
	
}
