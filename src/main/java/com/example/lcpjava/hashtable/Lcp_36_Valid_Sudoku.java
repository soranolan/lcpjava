package com.example.lcpjava.hashtable;

import java.util.HashSet;
import java.util.Set;

public class Lcp_36_Valid_Sudoku {
	
	/**
	 * time  : O(162)
	 * space : O(243)
	 * 
	 *    jjjjjjjjjjj
	 *    012 345 678
	 *    
	 * i0 53. .7. ...	i % 3 = 0
	 * i1 6.. 195 ...	i % 3 = 1
	 * i2 .98 ... .6.	i % 3 = 2
	 * 
	 * i3 8.. .6. ..3
	 * i4 4.. 8.3 ..1
	 * i5 7.. .2. ..6
	 * 
	 * i6 .6. ... 28.
	 * i7 ... 419 ..5
	 * i8 ... .8. .79
	 * 
	 * 
	 * Set<Character> leftSet <- null
	 * Set<Character> midSet <- null
	 * Set<Character> rightSet <- null
	 * 
	 * for int i <- 0; if i is lower than nine; i++
	 * 		Set<Character> rowSet <- new HashSet
	 * 		char[] row <- board[i]
	 * 		
	 * 		if i modulo three is equal to zero
	 * 			leftSet <- new HashSet
	 * 			midSet <- new HashSet
	 * 			rightSet <- new HashSet
	 * 		end if
	 * 		
	 * 		for int j <- 0; if j is lower than nine; j++
	 * 				char col <- row[j]
	 * 				
	 * 				if col is equal to '.'
	 * 					continue
	 * 				end if
	 * 				
	 * 				if rowSet can not add(col)
	 * 					return false
	 * 				end if
	 * 				
	 * 				int modulo <- j modulo nine
	 * 				
	 * 				if modulo is greater than or equal to zero && modulo is lower than or equal to two && leftSet can not add(col)
	 * 					return false
	 * 				end if
	 * 				
	 * 				if modulo is greater than two && modulo is lower than or equal to five && midSet can not add(col)
	 * 					return false
	 * 				end if
	 * 				
	 * 				if modulo is greater than five && modulo is lower than or equal to eight && rightSet can not add(col)
	 * 					return false
	 * 				end if
	 * 		end for
	 * end for
	 * 
	 * Set<Character> colSet <- new HashSet
	 * 
	 * for int col <- 0; if col is lower than nine; col++
	 * 		colSet <- new HashSet
	 * 		
	 * 		for int row <- 0; if row is lower than nine; row++
	 * 			char c <- board[row][col]
	 * 			
	 * 			if c is equal to '.'
	 * 				continue
	 * 			end if
	 * 			
	 * 			if colSet can not add(c)
	 * 				return false
	 * 			end if
	 * 		end for
	 * end for
	 * 
	 * return true
	 * */
	public boolean isValidSudoku_1(char[][] board) {
		Set<Character> leftSet = null;																				// S : O(9)
		Set<Character> midSet = null;																				// S : O(9)
		Set<Character> rightSet = null;																				// S : O(9)
		
		for (int i = 0; i < 9; i++) {																				// T : O(9)
			Set<Character> rowSet = new HashSet<>();																// S : O(9)
			char[] row = board[i];
			
			if (i % 3 == 0) {
				leftSet = new HashSet<>();
				midSet = new HashSet<>();
				rightSet = new HashSet<>();
			}
			
			for (int j = 0; j < 9; j++) {																			// T : O(9)
				char col = row[j];
				if (col == '.') { continue; }
				
				if (!rowSet.add(col)) { return false; }																// T : O(1)
				
				int modulo = j % 9;
				if (modulo >= 0 && modulo <= 2 && !leftSet.add(col)) { return false; }								// T : O(1)
				if (modulo > 2 && modulo <= 5 && !midSet.add(col)) { return false; }								// T : O(1)
				if (modulo > 5 && modulo <= 8 && !rightSet.add(col)) { return false; }								// T : O(1)
			}
		}
		
		Set<Character> colSet = new HashSet<>();																	// S : O(9)
		for (int col = 0; col < 9; col++) {																			// T : O(9)
			colSet = new HashSet<>();
			
			for (int row = 0; row < 9; row++) {																		// T : O(9)
				char c = board[row][col];
				if (c == '.') { continue; }
				
				if (!colSet.add(c)) { return false; }																// T : O(1)
			}
		}
		
		return true;
	}
	
	/**
	 * time  : O(81)
	 * space : O(243)
	 * 
	 * Set<String> rowSet <- new HashSet
	 * Set<String> colSet <- new HashSet
	 * Set<String> subSet <- new HashSet
	 * char[] row <- null
	 * 
	 * for int i <- 0; if i is lower than nine; i++
	 * 		row <- board[i]
	 * 		
	 * 		for int j <- 0; if j is lower than nine; j++
	 * 			char c <- row[j]
	 * 			
	 * 			if c is equal to '.'
	 * 				continue
	 * 			end if
	 * 			
	 * 			if rowSet can not add("row = " + i + ", value = " + c)
	 * 				return false
	 * 			end if
	 * 			
	 * 			if colSet can not add("col = " + j + ", value = " + c)
	 * 				return false
	 * 			end if
	 * 			
	 * 			if subSet can not add("subrow = " + i + ", subcol = " + j + ", value = " + c)
	 * 				return false
	 * 			end if
	 * 		end for
	 * end for
	 * 
	 * return true
	 * */
	public boolean isValidSudoku_2(char[][] board) {
		Set<String> rowSet = new HashSet<>();																		// S : O(81)
		Set<String> colSet = new HashSet<>();																		// S : O(81)
		Set<String> subSet = new HashSet<>();																		// S : O(81)
		char[] row = null;
		
		for (int i = 0; i < 9; i++) {																				// T : O(9)
			row = board[i];
			
			for (int j = 0; j < 9; j++) {																			// T : O(9)
				char c = row[j];
				if (c == '.') { continue; }
				
				if (!rowSet.add("row = " + i + ", val = " + c)) { return false; }									// T : O(1)
				if (!colSet.add("col = " + j + ", val = " + c)) { return false; }									// T : O(1)
				if (!subSet.add("subrow = " + i / 3 + ", subcol = " + j / 3 + ", val = " + c)) { return false; }	// T : O(1)
			}
		}
		
		return true;
	}
	
	/**
	 * time  : O(81)
	 * space : O(243)
	 * 
	 * int[][] rows <- new int[9][9]
	 * int[][] cols <- new int[9][9]
	 * int[][] subs <- new int[9][9]
	 * char[] row <- null
	 * 
	 * for int i <- 0; if i is lower than nine; i++
	 * 		row <- board[i]
	 * 		
	 * 		for int j <- 0; if j is lower than nine; j++
	 * 			char c <- row[j]
	 * 			
	 * 			if c is equal to '.'
	 * 				continue
	 * 			end if
	 * 			
	 * 			int index <- ((i divide three) times three) plus j divide three
	 * 			int value <- c minus '1'
	 * 			
	 * 			if rows[i][value] is equal to one
	 * 				return false
	 * 			end if
	 * 			
	 * 			if cols[j][value] is equal to one
	 * 				return false
	 * 			end if
	 * 			
	 * 			if subs[index][value] is equal to one
	 * 				return false
	 * 			end if
	 * 			
	 * 			rows[i][value] <- 1
	 * 			cols[j][value] <- 1
	 * 			subs[index][value] <- 1
	 * 		end for
	 * end for
	 * 
	 * return true
	 * */
	public boolean isValidSudoku_3(char[][] board) {
		int[][] rows = new int[9][9];																				// S : O(81)
		int[][] cols = new int[9][9];																				// S : O(81)
		int[][] subs = new int[9][9];																				// S : O(81)
		char[] row = null;
		
		for (int i = 0; i < 9; i++) {																				// T : O(9)
			row = board[i];
			
			for (int j = 0; j < 9; j++) {																			// T : O(9)
				char c = row[j];
				if (c == '.') { continue; }
				
				int index = (i / 3) * 3 + j / 3;																	// each row has three sub-boxes
				int value = c - '1';
				
				if (rows[i][value] == 1) { return false; }
				if (cols[j][value] == 1) { return false; }
				if (subs[index][value] == 1) { return false; }
				
				rows[i][value] = 1;
				cols[j][value] = 1;
				subs[index][value] = 1;
			}
		}
		
		return true;
	}
	
	/**
	 * time  : O(81)
	 * space : O(243)
	 * 
	 * boolean[][] rows <- new boolean[9][9]
	 * boolean[][] cols <- new boolean[9][9]
	 * boolean[][] subs <- new boolean[9][9]
	 * char[] row <- null
	 * 
	 * for int i <- 0; if i is lower than nine; i++
	 * 		row <- board[i]
	 * 		
	 * 		for int j <- 0; if j is lower than nine; j++
	 * 			char c <- row[j]
	 * 			
	 * 			if c is equal to '.'
	 * 				continue
	 * 			end if
	 * 			
	 * 			int index <- ((i divide three) times three) plus j divide three
	 * 			int value <- c minus '1'
	 * 			
	 * 			if rows[i][value] is true
	 * 				return false
	 * 			end if
	 * 			
	 * 			if cols[j][value] is true
	 * 				return false
	 * 			end if
	 * 			
	 * 			if subs[index][value] is true
	 * 				return false
	 * 			end if
	 * 			
	 * 			rows[i][value] <- true
	 * 			cols[j][value] <- true
	 * 			subs[index][value] <- true
	 * 		end for
	 * end for
	 * 
	 * return true
	 * */
	public boolean isValidSudoku_4(char[][] board) {
		boolean[][] rows = new boolean[9][9];																		// S : O(81)
		boolean[][] cols = new boolean[9][9];																		// S : O(81)
		boolean[][] subs = new boolean[9][9];																		// S : O(81)
		char[] row = null;
		
		for (int i = 0; i < 9; i++) {																				// T : O(9)
			row = board[i];
			
			for (int j = 0; j < 9; j++) {																			// T : O(9)
				char c = row[j];
				if (c == '.') { continue; }
				
				int index = (i / 3) * 3 + j / 3;
				int value = c - '1';
				
				if (rows[i][value]) { return false; }
				if (cols[j][value]) { return false; }
				if (subs[index][value]) { return false; }
				
				rows[i][value] = true;
				cols[j][value] = true;
				subs[index][value] = true;
			}
		}
		
		return true;
	}
	
	/**
	 * time  : O(81)
	 * space : O(27)
	 * 
	 * int[] rows <- new int[9]
	 * int[] cols <- new int[9]
	 * int[] subs <- new int[9]
	 * char[] row <- null
	 * 
	 * for int i <- 0; if i is lower than nine; i++
	 * 		row <- board[i]
	 * 		
	 * 		for int j <- 0; if j is lower than nine; j++
	 * 			char c <- row[j]
	 * 			
	 * 			if c is equal to '.'
	 * 				continue
	 * 			end if
	 * 			
	 * 			int index <- ((i divide three) times three) plus j divide three
	 * 			int value <- c minus '0'
	 * 			int bits <- 1 << value
	 * 			
	 * 			if rows[i] & bits is not equal to zero
	 * 				return false
	 * 			end if
	 * 			
	 * 			if cols[j] & bits is not equal to zero
	 * 				return false
	 * 			end if
	 * 			
	 * 			if subs[index] & bits is not equal to zero
	 * 				return false
	 * 			end if
	 * 			
	 * 			rows[i] <- rows[i] | bits
	 * 			cols[j] <- cols[j] | bits
	 * 			subs[index] <- subs[index] | bits
	 * 		end for
	 * end for
	 * 
	 * return true
	 * */
	public boolean isValidSudoku(char[][] board) {
		int[] rows = new int[9];																					// S : O(9)
		int[] cols = new int[9];																					// S : O(9)
		int[] subs = new int[9];																					// S : O(9)
		char[] row = null;
		
		for (int i = 0; i < 9; i++) {																				// T : O(9)
			row = board[i];
			
			for (int j = 0; j < 9; j++) {																			// T : O(9)
				char c = row[j];
				if (c == '.') { continue; }
				
				int index = (i / 3) * 3 + j / 3;
				int value = c - '0';
				int bit = 1 << value;
				
				if ((rows[i] & bit) != 0) { return false; }
				if ((cols[j] & bit) != 0) { return false; }
				if ((subs[index] & bit) != 0) { return false; }
				
				rows[i] |= bit;
				cols[j] |= bit;
				subs[index] |= bit;
			}
		}
		
		return true;
	}
	
}
