package com.example.lcpjava.array;

import java.util.ArrayList;
import java.util.List;

public class Lcp_1222_Queens_That_Can_Attack_the_King {
	
	/**
	 * time  : O(16 * n)
	 * space : O(1)
	 * 
	 * start from king, search 8 direction
	 * */
	public List<List<Integer>> queensAttacktheKing_1(int[][] queens, int[] king) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		int kRow = king[0];
		int kCol = king[1];
		
		// top
		int top = kRow - 1;
		boolean found = false;
		while (top >= 0 && !found) {																				// T : O(8)
			for (int[] queen : queens) {																			// T : O(n)
				if (queen[1] == kCol && queen[0] == top) {
					List<Integer> temp = new ArrayList<>();
					temp.add(top);
					temp.add(kCol);
					result.add(temp);
					found = true;
					break;
				}
			}
			top--;
		}
		
		// down
		int down = kRow + 1;
		found = false;
		while (down < 8 && !found) {																				// T : O(8)
			for (int[] queen : queens) {																			// T : O(n)
				if (queen[1] == kCol && queen[0] == down) {
					List<Integer> temp = new ArrayList<>();
					temp.add(down);
					temp.add(kCol);
					result.add(temp);
					found = true;
					break;
				}
			}
			down++;
		}
		
		// left
		int left = kCol - 1;
		found = false;
		while (left >= 0 && !found) {																				// T : O(8)
			for (int[] queen : queens) {																			// T : O(n)
				if (queen[0] == kRow && queen[1] == left) {
					List<Integer> temp = new ArrayList<>();
					temp.add(kRow);
					temp.add(left);
					result.add(temp);
					found = true;
					break;
				}
			}
			left--;
		}
		
		// right
		int right = kCol + 1;
		found = false;
		while (right < 8 && !found) {																				// T : O(8)
			for (int[] queen : queens) {																			// T : O(n)
				if (queen[0] == kRow && queen[1] == right) {
					List<Integer> temp = new ArrayList<>();
					temp.add(kRow);
					temp.add(right);
					result.add(temp);
					found = true;
					break;
				}
			}
			right++;
		}
		
		// top left
		top = kRow - 1;
		left = kCol - 1;
		found = false;
		while (top >= 0 && left >= 0 && !found) {																	// T : O(8)
			for (int[] queen : queens) {																			// T : O(n)
				if (queen[0] == top && queen[1] == left) {
					List<Integer> temp = new ArrayList<>();
					temp.add(top);
					temp.add(left);
					result.add(temp);
					found = true;
					break;
				}
			}
			top--;
			left--;
		}
		
		// top right
		top = kRow - 1;
		right = kCol + 1;
		found = false;
		while (top >= 0 && right < 8 && !found) {																	// T : O(8)
			for (int[] queen : queens) {																			// T : O(n)
				if (queen[0] == top && queen[1] == right) {
					List<Integer> temp = new ArrayList<>();
					temp.add(top);
					temp.add(right);
					result.add(temp);
					found = true;
					break;
				}
			}
			top--;
			right++;
		}
		
		// down left
		down = kRow + 1;
		left = kCol - 1;
		found = false;
		while (down < 8 && left >= 0 && !found) {																	// T : O(8)
			for (int[] queen : queens) {																			// T : O(n)
				if (queen[0] == down && queen[1] == left) {
					List<Integer> temp = new ArrayList<>();
					temp.add(down);
					temp.add(left);
					result.add(temp);
					found = true;
					break;
				}
			}
			down++;
			left--;
		}
		
		// down right
		down = kRow + 1;
		right = kCol + 1;
		found = false;
		while (down < 8 && right < 8 && !found) {																	// T : O(8)
			for (int[] queen : queens) {																			// T : O(n)
				if (queen[0] == down && queen[1] == right) {
					List<Integer> temp = new ArrayList<>();
					temp.add(down);
					temp.add(right);
					result.add(temp);
					found = true;
					break;
				}
			}
			down++;
			right++;
		}
		
		return result;
	}
	
	/**
	 * time  : O(n)
	 * space : O(64)
	 * 
	 * https://leetcode.com/problems/queens-that-can-attack-the-king/discuss/1232894/Java-Solution-for-simple-folks-like-me
	 * 
	 * memo the queen, speed up the find/search operation
	 * */
	public List<List<Integer>> queensAttacktheKing_2(int[][] queens, int[] king) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		boolean[][] visited = new boolean[8][8];																	// T : O(64)
		for (int[] queen : queens) { visited[queen[0]][queen[1]] = true; }											// T : O(n)
		
		int kRow = king[0];
		int kCol = king[1];
		
		// top
		int top = kRow - 1;
		while (top >= 0) {																							// T : O(8)
			if (visited[top][kCol]) {
				List<Integer> temp = new ArrayList<>();
				temp.add(top);
				temp.add(kCol);
				result.add(temp);
				break;
			}
			top--;
		}
		
		// down
		int down = kRow + 1;
		while (down < 8) {																							// T : O(8)
			if (visited[down][kCol]) {
				List<Integer> temp = new ArrayList<>();
				temp.add(down);
				temp.add(kCol);
				result.add(temp);
				break;
			}
			down++;
		}
		
		// left
		int left = kCol - 1;
		while (left >= 0) {																							// T : O(8)
			if (visited[kRow][left]) {
				List<Integer> temp = new ArrayList<>();
				temp.add(kRow);
				temp.add(left);
				result.add(temp);
				break;
			}
			left--;
		}
		
		// right
		int right = kCol + 1;
		while (right < 8) {																							// T : O(8)
			if (visited[kRow][right]) {
				List<Integer> temp = new ArrayList<>();
				temp.add(kRow);
				temp.add(right);
				result.add(temp);
				break;
			}
			right++;
		}
		
		// top left
		top = kRow - 1;
		left = kCol - 1;
		while (top >= 0 && left >= 0) {																				// T : O(8)
			if (visited[top][left]) {
				List<Integer> temp = new ArrayList<>();
				temp.add(top);
				temp.add(left);
				result.add(temp);
				break;
			}
			top--;
			left--;
		}
		
		// top right
		top = kRow - 1;
		right = kCol + 1;
		while (top >= 0 && right < 8) {																				// T : O(8)
			if (visited[top][right]) {
				List<Integer> temp = new ArrayList<>();
				temp.add(top);
				temp.add(right);
				result.add(temp);
				break;
			}
			top--;
			right++;
		}
		
		// down left
		down = kRow + 1;
		left = kCol - 1;
		while (down < 8 && left >= 0) {																				// T : O(8)
			if (visited[down][left]) {
				List<Integer> temp = new ArrayList<>();
				temp.add(down);
				temp.add(left);
				result.add(temp);
				break;
			}
			down++;
			left--;
		}
		
		// down right
		down = kRow + 1;
		right = kCol + 1;
		while (down < 8 && right < 8) {																				// T : O(8)
			if (visited[down][right]) {
				List<Integer> temp = new ArrayList<>();
				temp.add(down);
				temp.add(right);
				result.add(temp);
				break;
			}
			down++;
			right++;
		}
		
		return result;
	}
	
	/**
	 * time  : O(n)
	 * space : O(80)
	 * 
	 * https://leetcode.com/problems/queens-that-can-attack-the-king/discuss/924162/Java-0-ms-faster-than-100-Easy-to-understand-solution
	 * 
	 * create a direction array
	 * 
	 * 
	 * List<List<Integer>> result <- new ArrayList<List<Integer>>
	 * 
	 * int[][] direction <- eight direction
	 * 
	 * boolean[][] visited <- new boolean[8][8]
	 * 
	 * for int[] queen in queens
	 * 		visited[queen row][queen col] <- true
	 * end for
	 * 
	 * int kRow <- king[0]
	 * int kCol <- king[1]
	 * 
	 * for int[] direction in directions
	 * 		int row <- direction[0]
	 * 		int col <- direction[1]
	 * 		int qRow <- kRow plus row
	 * 		int qCol <- kCol plus col
	 * 		
	 * 		while qRow is greater than or equal to zero && qRow is lower than eight && qCol is greater than or equal to zero && qCol is lower than eight
	 * 			if visited[qRow][qCol] is true
	 * 				List<Integer> temp <- new ArrayList
	 * 				temp add qRow
	 * 				temp add qCol
	 * 				result add temp
	 * 				break
	 * 			end if
	 * 			
	 * 			qRow <- qRow plus row
	 * 			qCol <- qCol plus col
	 * 		end while
	 * end for
	 * 
	 * return result
	 * */
	public List<List<Integer>> queensAttacktheKing_3(int[][] queens, int[] king) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
		
		boolean[][] visited = new boolean[8][8];																	// T : O(64)
		for (int[] queen : queens) { visited[queen[0]][queen[1]] = true; }											// T : O(n)
		
		int kRow = king[0];
		int kCol = king[1];
		
		for (int[] direction : directions) {																		// T : O(8)
			int row = direction[0];
			int col = direction[1];
			int qRow = kRow + row;
			int qCol = kCol + col;
			
			while (qRow >= 0 && qRow < 8 && qCol >= 0 && qCol < 8) {												// T : O(8)
				if (visited[qRow][qCol]) {
					List<Integer> temp = new ArrayList<>();
					temp.add(qRow);
					temp.add(qCol);
					result.add(temp);
					break;
				}
				qRow += row;
				qCol += col;
			}
		}
		
		return result;
	}
	
	/**
	 * time  : O(n)
	 * space : O(64)
	 * 
	 * https://leetcode.com/problems/queens-that-can-attack-the-king/discuss/706347/Java-beat-100-DFS-solution
	 * 
	 * 
	 * List<List<Integer>> result <- new ArrayList<List<Integer>>
	 * 
	 * int[][] direction <- eight direction
	 * 
	 * boolean[][] visited <- new boolean[8][8]
	 * 
	 * for int[] queen in queens
	 * 		visited[queen row][queen col] <- true
	 * end for
	 * 
	 * for int[] direction in directions
	 * 		DFS(king row plus direction row, king column plus direction column, direction, visited, result)
	 * end for
	 * 
	 * return result
	 * */
	public List<List<Integer>> queensAttacktheKing_4(int[][] queens, int[] king) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
		
		boolean[][] visited = new boolean[8][8];																	// S : O(64)
		for (int[] queen : queens) { visited[queen[0]][queen[1]] = true; }											// T : O(n)
		
		for (int[] direction : directions) { DFS(king[0] + direction[0], king[1] + direction[1], direction, visited, result); }
		
		return result;
	}
	
	/**
	 * if row is lower than zero || row is greater than or equal to eight || col is lower than zero || col is greater than or equal to eight
	 * 		return
	 * end if
	 * 
	 * if visited[row][col] is true
	 * 		List<Integer> temp <- new ArrayList
	 * 		temp add row
	 * 		temp add col
	 * 		result add temp
	 * 		return
	 * end if
	 * 
	 * DFS(row plus direction row, column plus direction column, direction, visited, result)
	 * */
	public void DFS(int row, int col, int[] direction, boolean[][] visited, List<List<Integer>> result) {
		if (row < 0 || row >= 8 || col < 0 || col >= 8) { return; }
		
		if (visited[row][col]) {
			List<Integer> temp = new ArrayList<>();
			temp.add(row);
			temp.add(col);
			result.add(temp);
			return;
		}
		
		DFS(row + direction[0], col + direction[1], direction, visited, result);
	}
	
	/**
	 * time  : O(n)
	 * space : O(8)
	 * 
	 * use variable and array to store result
	 * */
	public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		int top = -1;
		int down = -1;
		int left = -1;
		int right = -1;
		int[] topleft = { -1, -1 };																					// S : O(2)
		int[] topright = { -1, -1 };																				// S : O(2)
		int[] downleft = { -1, -1 };																				// S : O(2)
		int[] downright = { -1, -1 };																				// S : O(2)
		
		int kRow = king[0];
		int kCol = king[1];
		
		for (int[] queen : queens) {																				// T : O(n)
			int qRow = queen[0];
			int qCol = queen[1];
			
			if (qRow == kRow) {																						// same row
				if (qCol > kCol) {																					// right
					if (right == -1) {
						right = qCol;
					} else {
						right = Math.min(right, qCol);
					}
				} else {																							// left
					if (left == -1) {
						left = qCol;
					} else {
						left = Math.max(left, qCol);
					}
				}
			}
			
			if (qCol == kCol) {																						// same column
				if (qRow > kRow) {																					// down
					if (down == -1) {
						down = qRow;
					} else {
						down = Math.min(down, qRow);
					}
				} else {																							// top
					if (top == -1) {
						top = qRow;
					} else {
						top = Math.max(top, qRow);
					}
				}
			}
			
			if (kRow - qRow == kCol - qCol) {
				if (qRow > kRow) {																					// down right
					if (downright[0] == -1) {
						downright[0] = qRow;
						downright[1] = qCol;
					} else {
						if (qRow < downright[0]) {
							downright[0] = qRow;
							downright[1] = qCol;
						}
					}
				} else {																							// top left
					if (topleft[0] == -1) {
						topleft[0] = qRow;
						topleft[1] = qCol;
					} else {
						if (qCol > topleft[1]) {
							topleft[0] = qRow;
							topleft[1] = qCol;
						}
					}
				}
			}
			
			if (kRow - qRow == -(kCol - qCol)) { 
				if (qRow > kRow) {																					// down left
					if (downleft[0] == -1) {
						downleft[0] = qRow;
						downleft[1] = qCol;
					} else {
						if (qRow < downleft[0]) {
							downleft[0] = qRow;
							downleft[1] = qCol;
						}
					}
				} else {																							// top right
					if (topright[0] == -1) {
						topright[0] = qRow;
						topright[1] = qCol;
					} else {
						if (qRow > topright[0]) {
							topright[0] = qRow;
							topright[1] = qCol;
						}
					}
				}
			}
		}
		
		List<Integer> temp = null;
		
		if (top != -1) {
			temp = new ArrayList<>();
			temp.add(top);
			temp.add(kCol);
			result.add(temp);
		}
		
		if (down != -1) {
			temp = new ArrayList<>();
			temp.add(down);
			temp.add(kCol);
			result.add(temp);
		}
		
		if (left != -1) {
			temp = new ArrayList<>();
			temp.add(kRow);
			temp.add(left);
			result.add(temp);
		}
		
		if (right != -1) {
			temp = new ArrayList<>();
			temp.add(kRow);
			temp.add(right);
			result.add(temp);
		}
		
		if (topleft[0] != -1) {
			temp = new ArrayList<>();
			temp.add(topleft[0]);
			temp.add(topleft[1]);
			result.add(temp);
		}
		
		if (topright[0] != -1) {
			temp = new ArrayList<>();
			temp.add(topright[0]);
			temp.add(topright[1]);
			result.add(temp);
		}
		
		if (downleft[0] != -1) {
			temp = new ArrayList<>();
			temp.add(downleft[0]);
			temp.add(downleft[1]);
			result.add(temp);
		}
		
		if (downright[0] != -1) {
			temp = new ArrayList<>();
			temp.add(downright[0]);
			temp.add(downright[1]);
			result.add(temp);
		}
		
		return result;
	}
	
}
