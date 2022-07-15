package com.example.lcpjava.array;

public class Lcp_695_Max_Area_of_Island {
	
	/**
	 * time  : O(m * n)
	 * space : O(m * n)
	 * */
	public int maxAreaOfIsland_1(int[][] grid) {
		int rows = grid.length;																						// m
		int cols = grid[0].length;																					// n
		
		int maxArea = 0;
		int[] area = new int[1];
		boolean[][] visited = new boolean[rows][cols];																// S : O(m * n)
		
		for (int row = 0; row < rows; row++) {																		// T : O(m)
			for (int col = 0; col < cols; col++) {																	// T : O(n)
				if (grid[row][col] == 0 || visited[row][col]) { continue; }
				
				travel_1(row, col, grid, visited, area);
				
				maxArea = Math.max(maxArea, area[0]);
				area[0] = 0;
			}
		}
		
		return maxArea;
	}
	
	private void travel_1(int row, int col, int[][] grid, boolean[][] visited, int[] area) {
		int rows = grid.length;
		int cols = grid[0].length;
		
		if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0 || visited[row][col]) { return; }
		
		visited[row][col] = true;
		area[0]++;
		
		travel_1(row - 1, col, grid, visited, area);
		travel_1(row + 1, col, grid, visited, area);
		travel_1(row, col - 1, grid, visited, area);
		travel_1(row, col + 1, grid, visited, area);
	}
	
	/**
	 * time  : O(m * n)
	 * space : O(m * n)
	 * 
	 * https://leetcode.com/problems/max-area-of-island/discuss/108533/JavaC%2B%2B-Straightforward-dfs-solution
	 * */
	public int maxAreaOfIsland(int[][] grid) {
		int rows = grid.length;																						// m
		int cols = grid[0].length;																					// n
		
		int maxArea = 0;
		boolean[][] visited = new boolean[rows][cols];																// S : O(m * n)
		
		for (int row = 0; row < rows; row++) {																		// T : O(m)
			for (int col = 0; col < cols; col++) {																	// T : O(n)
				if (grid[row][col] == 0 || visited[row][col]) { continue; }
				
				maxArea = Math.max(maxArea, travel(row, col, grid, visited));
			}
		}
		
		return maxArea;
	}
	
	private int travel(int row, int col, int[][] grid, boolean[][] visited) {
		int rows = grid.length;
		int cols = grid[0].length;
		
		if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0 || visited[row][col]) { return 0; }
		
		visited[row][col] = true;
		
		return 1 + travel(row - 1, col, grid, visited) + travel(row + 1, col, grid, visited) + travel(row, col - 1, grid, visited) + travel(row, col + 1, grid, visited);
	}
	
	/**
	 * Union Find
	 * 
	 * https://leetcode.com/problems/max-area-of-island/discuss/186891/Java.-BFSDFSUnion-Find.
	 * */
	
}
