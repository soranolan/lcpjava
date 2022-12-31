package com.example.lcpjava.array;

public class Lcp_980_Unique_Paths_III {
	
	/**
	 * time  : O(O ^ (m * n))
	 * space : O(m * n)
	 * 
	 * https://leetcode.com/problems/unique-paths-iii/solutions/221946/java-python-brute-force-backtracking/
	 * https://leetcode.com/problems/unique-paths-iii/solutions/221946/java-python-brute-force-backtracking/comments/225131
	 * */
	public int uniquePathsIII_1(int[][] grid) {
		int[] result = new int[1];
		int rows = grid.length;																						// m
		int cols = grid[0].length;																					// n
		int startRow = 0;
		int startCol = 0;
		int[] emptyCell = new int[] { 1 };																			// count in start point
		
		for (int row = 0; row < rows; row++) {																		// T : O(m)
			for (int col = 0; col < cols; col++) {																	// T : O(n)
				if (grid[row][col] == 0) {
					emptyCell[0]++;
				} else if (grid[row][col] == 1) {
					startRow = row;
					startCol = col;
				}
			}
		}
		
		DFS(startRow, startCol, grid, emptyCell, result);
		
		return result[0];
	}
	
	private void DFS(int row, int col, int[][] grid, int[] emptyCell, int[] result) {
		int rows = grid.length;
		int cols = grid[0].length;
		if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] < 0) { return; }
		
		if (grid[row][col] == 2) {
			if (emptyCell[0] == 0) { result[0]++; }
			return;
		}
		
		grid[row][col] = -2;
		emptyCell[0]--;
		
		DFS(row + 1, col, grid, emptyCell, result);
		DFS(row - 1, col, grid, emptyCell, result);
		DFS(row, col + 1, grid, emptyCell, result);
		DFS(row, col - 1, grid, emptyCell, result);
		
		grid[row][col] = 0;
		emptyCell[0]++;
	}
	
	/**
	 * time  : O(O ^ (m * n))
	 * space : O(m * n)
	 * */
	public int uniquePathsIII_2(int[][] grid) {
		int[] result = new int[1];
		int rows = grid.length;																						// m
		int cols = grid[0].length;																					// n
		int startRow = 0;
		int startCol = 0;
		int[] emptyCell = new int[] { 1 };																			// count in start point
		boolean[][] visited = new boolean[rows][cols];
		
		for (int row = 0; row < rows; row++) {																		// T : O(m)
			for (int col = 0; col < cols; col++) {																	// T : O(n)
				if (grid[row][col] == 0) {
					emptyCell[0]++;
				} else if (grid[row][col] == 1) {
					startRow = row;
					startCol = col;
				}
			}
		}
		
		DFS(startRow, startCol, grid, emptyCell, visited, result);
		
		return result[0];
	}
	
	private void DFS(int row, int col, int[][] grid, int[] emptyCell, boolean[][] visited, int[] result) {
		int rows = grid.length;
		int cols = grid[0].length;
		if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == -1 || visited[row][col]) { return; }
		
		if (grid[row][col] == 2) {
			if (emptyCell[0] == 0) { result[0]++; }
			return;
		}
		
		visited[row][col] = true;
		emptyCell[0]--;
		
		DFS(row + 1, col, grid, emptyCell, visited, result);
		DFS(row - 1, col, grid, emptyCell, visited, result);
		DFS(row, col + 1, grid, emptyCell, visited, result);
		DFS(row, col - 1, grid, emptyCell, visited, result);
		
		visited[row][col] = false;
		emptyCell[0]++;
	}
	
	/**
	 * time  : O(O ^ (m * n))
	 * space : O(m * n)
	 * 
	 * https://leetcode.com/problems/unique-paths-iii/solutions/1554054/c-dfs-backtracking-bit-manipulation-short-simple-w-explanation-beats-100/?orderBy=most_votes
	 * */
	public int uniquePathsIII(int[][] grid) {
		int[] result = new int[1];
		int rows = grid.length;																						// m
		int cols = grid[0].length;																					// n
		int startRow = 0;
		int startCol = 0;
		int mask = 0;
		
		for (int row = 0; row < rows; row++) {																		// T : O(m)
			for (int col = 0; col < cols; col++) {																	// T : O(n)
				if (grid[row][col] == 1) {
					startRow = row;
					startCol = col;
				}
				if (grid[row][col] != -1) { mask |= (1 << (row * cols + col)); }
			}
		}
		
		DFS(startRow, startCol, grid, mask, result);
		
		return result[0];
	}
	
	private void DFS(int row, int col, int[][] grid, int mask, int[] result) {
		int rows = grid.length;
		int cols = grid[0].length;
		int bit = 1 << (row * cols + col);
		if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == -1 || (mask & bit) == 0) { return; }
		
		mask ^= bit;
		
		if (grid[row][col] == 2) {
			if (mask == 0) { result[0]++; }
			return;
		}
		
		DFS(row + 1, col, grid, mask, result);
		DFS(row - 1, col, grid, mask, result);
		DFS(row, col + 1, grid, mask, result);
		DFS(row, col - 1, grid, mask, result);
	}
	
}
