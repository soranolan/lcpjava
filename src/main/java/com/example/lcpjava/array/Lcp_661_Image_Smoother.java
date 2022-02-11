package com.example.lcpjava.array;

public class Lcp_661_Image_Smoother {
	
	/**
	 * time  : O(n * m)
	 * space : O(n * m)
	 * 
	 * int rows <- array length
	 * int cols <- array[0] length
	 * int[][] result <- new int[rows][cols]
	 * 
	 * for int row <- 0; if row is lower than rows; row++
	 * 		for int col <- 0; if col is lower than cols; col++
	 * 			int sum <- 0
	 * 			int count <- 0
	 * 			
	 * 			int n1 <- smoother(array, row minus one, col minus one)
	 * 			if n1 is not equal to minus one
	 * 				sum <- sum plus n1
	 * 				count++
	 * 			end if
	 * 			
	 * 			int n2 <- smoother(array, row minus one, col)
	 * 			if n2 is not equal to minus one
	 * 				sum <- sum plus n2
	 * 				count++
	 * 			end if
	 * 			
	 * 			int n3 <- smoother(array, row minus one, col plus one)
	 * 			if n3 is not equal to minus one
	 * 				sum <- sum plus n3
	 * 				count++
	 * 			end if
	 * 			
	 * 			int n4 <- smoother(array, row, col minus one)
	 * 			if n4 is not equal to minus one
	 * 				sum <- sum plus n4
	 * 				count++
	 * 			end if
	 * 			
	 * 			int n5 <- smoother(array, row, col)
	 * 			if n5 is not equal to minus one
	 * 				sum <- sum plus n5
	 * 				count++
	 * 			end if
	 * 			
	 * 			int n6 <- smoother(array, row, col plus one)
	 * 			if n6 is not equal to minus one
	 * 				sum <- sum plus n6
	 * 				count++
	 * 			end if
	 * 			
	 * 			int n7 <- smoother(array, row plus one, col minus one)
	 * 			if n7 is not equal to minus one
	 * 				sum <- sum plus n7
	 * 				count++
	 * 			end if
	 * 			
	 * 			int n8 <- smoother(array, row plus one, col)
	 * 			if n8 is not equal to minus one
	 * 				sum <- sum plus n8
	 * 				count++
	 * 			end if
	 * 			
	 * 			int n9 <- smoother(array, row plus one, col plus one)
	 * 			if n9 is not equal to minus one
	 * 				sum <- sum plus n9
	 * 				count++
	 * 			end if
	 * 			
	 * 			result[row][col] <- sum divide count
	 * 		end for
	 * end for
	 * 
	 * return result
	 * */
	public int[][] imageSmoother_1(int[][] img) {
		int rows = img.length;
		int cols = img[0].length;
		int[][] result = new int[rows][cols];																		// S : O(n * m)
		
		for (int row = 0; row < rows; row++) {																		// T : O(n)
			for (int col = 0; col < cols; col++) {																	// T : O(m)
				int sum = 0;
				int count = 0;
				
				int n1 = smoother_1(img, row - 1, col - 1);
				if (n1 != -1) {
					sum += n1;
					count++;
				}
				
				int n2 = smoother_1(img, row - 1, col);
				if (n2 != -1) {
					sum += n2;
					count++;
				}
				
				int n3 = smoother_1(img, row - 1, col + 1);
				if (n3 != -1) {
					sum += n3;
					count++;
				}
				
				int n4 = smoother_1(img, row, col - 1);
				if (n4 != -1) {
					sum += n4;
					count++;
				}
				
				int n5 = smoother_1(img, row, col);
				if (n5 != -1) {
					sum += n5;
					count++;
				}
				
				int n6 = smoother_1(img, row, col + 1);
				if (n6 != -1) {
					sum += n6;
					count++;
				}
				
				int n7 = smoother_1(img, row + 1, col - 1);
				if (n7 != -1) {
					sum += n7;
					count++;
				}
				
				int n8 = smoother_1(img, row + 1, col);
				if (n8 != -1) {
					sum += n8;
					count++;
				}
				
				int n9 = smoother_1(img, row + 1, col + 1);
				if (n9 != -1) {
					sum += n9;
					count++;
				}
				
				result[row][col] = sum / count;
			}
		}
		
		return result;
	}
	
	/**
	 * int rows <- array length
	 * int cols <- array[0] length
	 * 
	 * if row is lower than zero || row is greater than or equal to rows || col is lower than zero || col is greater than or equal to cols
	 * 		return minus one
	 * end if
	 * 
	 * return array[row][col]
	 * */
	public int smoother_1(int[][] img, int row, int col) {
		int rows = img.length;
		int cols = img[0].length;
		
		if (row < 0 || row >= rows || col < 0 || col >= cols) { return -1; }
		
		return img[row][col];
	}
	
	/**
	 * time  : O(n * m)
	 * space : O(n * m)
	 * 
	 * int rows <- array length
	 * int cols <- array[0] length
	 * int[][] result <- new int[rows][cols]
	 * 
	 * for int row <- 0; if row is lower than rows; row++
	 * 		for int col <- 0; if col is lower than cols; col++
	 * 			result[row][col] <- smoother(array, row, col)
	 * 		end for
	 * end for
	 * 
	 * return result
	 * */
	public int[][] imageSmoother_2(int[][] img) {
		int rows = img.length;
		int cols = img[0].length;
		int[][] result = new int[rows][cols];																		// S : O(n * m)
		
		for (int row = 0; row < rows; row++) {																		// T : O(n)
			for (int col = 0; col < cols; col++) {																	// T : O(m)
				result[row][col] = smoother_2(img, row, col);
			}
		}
		
		return result;
	}
	
	/**
	 * int rows <- array length
	 * int cols <- array[0] length
	 * 
	 * int sum <- 0
	 * int count <- 0
	 * 
	 * if row minus one is greater than or equal to zero && col minus one is greater than or equal to zero
	 * 		sum <- sum plus array[row minus one][col minus one]
	 * 		count++
	 * end if
	 * 
	 * if row minus one is greater than or equal to zero && col is greater than or equal to zero
	 * 		sum <- sum plus array[row minus one][col]
	 * 		count++
	 * end if
	 * 
	 * if row minus one is greater than or equal to zero && col plus one is lower than cols
	 * 		sum <- sum plus array[row minus one][col plus one]
	 * 		count++
	 * end if
	 * 
	 * if row is greater than or equal to zero && col minus one is greater than or equal to zero
	 * 		sum <- sum plus array[row][col minus one]
	 * 		count++
	 * end if
	 * 
	 * if row is greater than or equal to zero && col is greater than or equal to zero
	 * 		sum <- sum plus array[row][col]
	 * 		count++
	 * end if
	 * 
	 * if row is greater than or equal to zero && col plus one is lower than cols
	 * 		sum <- sum plus array[row][col plus one]
	 * 		count++
	 * end if
	 * 
	 * if row plus one is lower than rows && col minus one is greater than or equal to zero
	 * 		sum <- sum plus array[row plus one][col minus one]
	 * 		count++
	 * end if
	 * 
	 * if row plus one is lower than rows && col is greater than or equal to zero
	 * 		sum <- sum plus array[row plus one][col]
	 * 		count++
	 * end if
	 * 
	 * if row plus one is lower than rows && col plus one is lower than cols
	 * 		sum <- sum plus array[row plus one][col plus one]
	 * 		count++
	 * end if
	 * 
	 * return sum divide count
	 * */
	public int smoother_2(int[][] img, int row, int col) {
		int rows = img.length;
		int cols = img[0].length;
		
		int sum = 0;
		int count = 0;
		
		if (row - 1 >= 0 && col - 1 >= 0) {
			sum += img[row - 1][col - 1];
			count++;
		}
		
		if (row - 1 >= 0 && col >= 0) {
			sum += img[row - 1][col];
			count++;
		}
		
		if (row - 1 >= 0 && col + 1 < cols) {
			sum += img[row - 1][col + 1];
			count++;
		}
		
		if (row >= 0 && col - 1 >= 0) {
			sum += img[row][col - 1];
			count++;
		}
		
		if (row >= 0 && col >= 0) {
			sum += img[row][col];
			count++;
		}
		
		if (row >= 0 && col + 1 < cols) {
			sum += img[row][col + 1];
			count++;
		}
		
		if (row + 1 < rows && col - 1 >= 0) {
			sum += img[row + 1][col - 1];
			count++;
		}
		
		if (row + 1 < rows && col >= 0) {
			sum += img[row + 1][col];
			count++;
		}
		
		if (row + 1 < rows && col + 1 < cols) {
			sum += img[row + 1][col + 1];
			count++;
		}
		
		return sum / count;
	}
	
	/**
	 * time  : O(n * m)
	 * space : O(n * m)
	 * 
	 * int rows <- array length
	 * int cols <- array[0] length
	 * int[][] result <- new int[rows][cols]
	 * 
	 * for int row <- 0; if row is lower than rows; row++
	 * 		for int col <- 0; if col is lower than cols; col++
	 * 			result[row][col] <- smoother(array, row, col)
	 * 		end for
	 * end for
	 * 
	 * return result
	 * */
	public int[][] imageSmoother_3(int[][] img) {
		int rows = img.length;
		int cols = img[0].length;
		int[][] result = new int[rows][cols];																		// S : O(n * m)
		
		for (int row = 0; row < rows; row++) {																		// T : O(n)
			for (int col = 0; col < cols; col++) {																	// T : O(m)
				result[row][col] = smoother_3(img, row, col);
			}
		}
		
		return result;
	}
	
	/**
	 * int rows <- array length
	 * int cols <- array[0] length
	 * 
	 * int sum <- 0
	 * int count <- 0
	 * 
	 * for int i <- minus one; if i is lower than two; i++
	 * 		for int j <- minus one; if j is lower than two; j++
	 * 			int r <- row plus i
	 * 			int c <- col plus j
	 * 			
	 * 			if r is lower than zero || r is greater than or equal to rows || c is lower than zero || c is greater than or equal to cols
	 * 				continue
	 * 			end if
	 * 			
	 * 			sum <- sum plus array[r][c]
	 * 			count++
	 * 		end for
	 * end for
	 * 
	 * return sum divide count
	 * */
	public int smoother_3(int[][] img, int row, int col) {
		int rows = img.length;
		int cols = img[0].length;
		
		int sum = 0;
		int count = 0;
		
		for (int i = -1; i < 2; i++) {																				// T : O(3)
			for (int j = -1; j < 2; j++) {																			// T : O(3)
				int r = row + i;
				int c = col + j;
				
				if (r < 0 || r >= rows || c < 0 || c >= cols) { continue; }
				
				sum += img[r][c];
				count++;
			}
		}
		
		return sum / count;
	}
	
	/**
	 * time  : O(n * m)
	 * space : O(1)
	 * 
	 * int rows <- array length
	 * int cols <- array[0] length
	 * 
	 * for int row <- 0; if row is lower than rows; row++
	 * 		for int col <- 0; if col is lower than cols; col++
	 * 			int average <- smoother(array, row, col)
	 * 			array[row][col] <- array[row][col] | (average << 8)
	 * 		end for
	 * end for
	 * 
	 * for int row <- 0; if row is lower than rows; row++
	 * 		for int col <- 0; if col is lower than cols; col++
	 * 			array[row][col] <- array[row][col] >> 8
	 * 		end for
	 * end for
	 * 
	 * return array
	 * */
	public int[][] imageSmoother(int[][] img) {
		int rows = img.length;
		int cols = img[0].length;
		
		for (int row = 0; row < rows; row++) {																		// T : O(n)
			for (int col = 0; col < cols; col++) {																	// T : O(m)
				int average = smoother(img, row, col); 
				img[row][col] |= average << 8;
			}
		}
		
		for (int row = 0; row < rows; row++) {																		// T : O(n)
			for (int col = 0; col < cols; col++) {																	// T : O(m)
				img[row][col] >>= 8;
			}
		}
		
		return img;
	}
	
	/**
	 * int rows <- array length
	 * int cols <- array[0] length
	 * 
	 * int sum <- 0
	 * int count <- 0
	 * 
	 * for int i <- minus one; if i is lower than two; i++
	 * 		for int j <- minus one; if j is lower than two; j++
	 * 			int r <- row plus i
	 * 			int c <- col plus j
	 * 			
	 * 			if r is lower than zero || r is greater than or equal to rows || c is lower than zero || c is greater than or equal to cols
	 * 				continue
	 * 			end if
	 * 			
	 * 			int number <- array[r][c]
	 * 			number <- number & HEX(FF)
	 * 			sum <- sum plus number
	 * 			count++
	 * 		end for
	 * end for
	 * 
	 * return sum divide count
	 * */
	public int smoother(int[][] img, int row, int col) {
		int rows = img.length;
		int cols = img[0].length;
		
		int sum = 0;
		int count = 0;
		
		for (int i = -1; i < 2; i++) {																				// T : O(3)
			for (int j = -1; j < 2; j++) {																			// T : O(3)
				int r = row + i;
				int c = col + j;
				
				if (r < 0 || r >= rows || c < 0 || c >= cols) { continue; }
				
				int num = img[r][c];
				num &= 0xFF;																						// same with Lcp_1394_Find_Lucky_Integer_in_an_Array
				sum += num;
				count++;
			}
		}
		
		return sum / count;
	}
	
}
