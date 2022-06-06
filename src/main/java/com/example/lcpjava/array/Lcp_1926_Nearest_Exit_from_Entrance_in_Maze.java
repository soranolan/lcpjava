package com.example.lcpjava.array;

import java.util.LinkedList;
import java.util.Queue;

public class Lcp_1926_Nearest_Exit_from_Entrance_in_Maze {
	
	/**
	 * time  : O(n * m)
	 * space : O(n * m)
	 * */
	public int nearestExit_1(char[][] maze, int[] entrance) {
		int steps = 10001;
		int rows = maze.length;																						// m
		int cols = maze[0].length;																					// n
		boolean[][] visited = new boolean[rows][cols];																// S : O(n * m)
		
		Queue<int[]> queue = new LinkedList<>();																	// S : O(3 * n * m)
		queue.offer(new int[] { entrance[0], entrance[1], 0 });
		
		while (!queue.isEmpty()) {																					// T : O(n * m)
			int[] current = queue.poll();
			int row = current[0];
			int col = current[1];
			int step = current[2];
			
			// boundary
			if (row < 0 || row >= rows || col < 0 || col >= cols) { continue; }
			
			// wall
			if (maze[row][col] == '+') { continue; }
			
			// visited
			if (visited[row][col]) { continue; }
			
			// not entrance
			if (row != entrance[0] || col != entrance[1]) {
				
				// exit
				if (row == 0 || row == rows - 1 || col == 0 || col == cols - 1) {
					steps = Math.min(steps, step);
					continue;
				}
			}
			
			visited[row][col] = true;
			
			queue.offer(new int[] { row - 1, col, step + 1 });
			queue.offer(new int[] { row + 1, col, step + 1 });
			queue.offer(new int[] { row, col - 1, step + 1 });
			queue.offer(new int[] { row, col + 1, step + 1 });
		}
		
		return steps == 10001 ? -1 : steps;
	}
	
	/**
	 * time  : O(n * m)
	 * space : O(n * m)
	 * 
	 * https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/discuss/1330438/Simple-BFS-(Java)-or-7ms-or-Beats-100
	 * */
	public int nearestExit(char[][] maze, int[] entrance) {
		int steps = 0;
		int rows = maze.length;																						// m
		int cols = maze[0].length;																					// n
		boolean[][] visited = new boolean[rows][cols];																// S : O(n * m)
		int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };											// S : O(8)
		
		Queue<int[]> queue = new LinkedList<>();																	// S : O(2 * n * m)
		queue.offer(new int[] { entrance[0], entrance[1] });
		
		while (!queue.isEmpty()) {																					// T : O(n * m)
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				int[] current = queue.poll();
				int currentRow = current[0];
				int currentCol = current[1];
				
				// not entrance
				if (currentRow != entrance[0] || currentCol != entrance[1]) {
					
					// exit
					if (currentRow == 0 || currentRow == rows - 1 || currentCol == 0 || currentCol == cols - 1) { return steps; }
				}
				
				for (int[] direction : directions) {
					int row = currentRow + direction[0];
					int col = currentCol + direction[1];
					
					// boundary
					if (row < 0 || row >= rows || col < 0 || col >= cols) { continue; }
					
					// wall
					if (maze[row][col] == '+') { continue; }
					
					// visited
					if (visited[row][col]) { continue; }
					
					visited[row][col] = true;
					
					queue.offer(new int[] { row, col });
				}
			}
			
			steps++;
		}
		
		return -1;
	}
	
}
