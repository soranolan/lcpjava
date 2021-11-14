package com.example.lcpjava.queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Lcp_200_Number_of_Islands {
	
	/**
	 * time  : O(m * n)
	 * space : O(m * n)
	 * 
	 * int rows <- grid length
	 * int cols <- grid[0] length
	 * int islands <- 0
	 * 
	 * Queue<String> queue <- new LinkedList
	 * Set<String> visited <- new HashSet
	 * 
	 * for int row <- 0; if row is lower than rows; row++
	 * 		for int col <- 0; if col is lower than cols; col++
	 * 			String coordinate <- row plus comma plus col
	 * 			if visited contains coordinate || grid[row][col] is equal to '0'
	 * 				continue
	 * 			end if
	 * 			
	 * 			queue offer(coordinate)
	 * 			BFS(queue, visited, grid)
	 * 			islands++
	 * 		end for
	 * end for
	 * 
	 * return islands
	 * */
	public int numIslands_1(char[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		int islands = 0;
		
		Queue<String> queue = new LinkedList<>();																	// S : O(m * n)
		Set<String> visited = new HashSet<>();																		// S : O(m * n)
		
		for (int row = 0; row < rows; row++) {																		// T : O(m)
			for (int col = 0; col < cols; col++) {																	// T : O(n)
				String coordinate = row + "," + col;
				if (visited.contains(coordinate) || grid[row][col] == '0') { continue; }							// T : O(1)
				
				queue.offer(coordinate);																			// T : O(1)
				BFS_1(queue, visited, grid);
				islands++;
			}
		}
		
		return islands;
	}
	
	/**
	 * int rows <- grid length
	 * int cols <- grid[0] length
	 * 
	 * while queue is not empty
	 * 		String coordinate <- queue poll
	 * 		int row <- coordinate split comma to array[0], to integer
	 * 		int col <- coordinate split comma to array[1], to integer
	 * 		
	 * 		if row is lower than zero || col is lower than zero || row is greater than or equal to rows || col is greater than or equal to cols || visited contains coordinate || grid[row][col] is equal to '0'
	 * 			continue
	 * 		end if
	 * 		
	 * 		visited add coordinate
	 * 		
	 * 		queue offer((row minus one) plus comma plus col)
	 * 		queue offer((row plus one) plus comma plus col)
	 * 		queue offer(row plus comma plus (col minus one))
	 * 		queue offer(row plus comma plus (col plus one))
	 * end while
	 * */
	public void BFS_1(Queue<String> queue, Set<String> visited, char[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		
		while (!queue.isEmpty()) {
			String coordinate = queue.poll();																		// T : O(1)
			int row = Integer.parseInt(coordinate.split(",")[0]);
			int col = Integer.parseInt(coordinate.split(",")[1]);
			
			if (row < 0 || col < 0 || row >= rows || col >= cols || visited.contains(coordinate) || grid[row][col] == '0') { continue; }
			
			visited.add(coordinate);																				// T : O(1)
			
			queue.offer((row - 1) + "," + col);																		// ¡ô
			queue.offer((row + 1) + "," + col);																		// ¡õ
			queue.offer(row + "," + (col - 1));																		// ¡ö
			queue.offer(row + "," + (col + 1));																		// ¡÷
		}
	}
	
	/**
	 * time  : O(m * n)
	 * space : O(m * n)
	 * 
	 * int rows <- grid length
	 * int cols <- grid[0] length
	 * int islands <- 0
	 * 
	 * Queue<int[]> queue <- new LinkedList
	 * 
	 * for int row <- 0; if row is lower than rows; row++
	 * 		for int col <- 0; if col is lower than cols; col++
	 * 			if grid[row][col] is not equal to '1'
	 * 				continue
	 * 			end if
	 * 			
	 * 			queue offer(int array [ row, col ])
	 * 			BFS(queue, grid)
	 * 			islands++
	 * 		end for
	 * end for
	 * 
	 * return islands
	 * */
	public int numIslands_2(char[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		int islands = 0;
		
		Queue<int[]> queue = new LinkedList<>();																	// S : O(m * n)
		
		for (int row = 0; row < rows; row++) {																		// T : O(m)
			for (int col = 0; col < cols; col++) {																	// T : O(n)
				if (grid[row][col] != '1') { continue; }
				
				queue.offer(new int[] { row, col });																// T : O(1)
				BFS_2(queue, grid);
				islands++;
			}
		}
		
		return islands;
	}
	
	/**
	 * int rows <- grid length
	 * int cols <- grid[0] length
	 * 
	 * while queue is not empty
	 * 		int[] coordinate <- queue poll
	 * 		int row <- coordinate[0]
	 * 		int col <- coordinate[1]
	 * 		
	 * 		if row is lower than zero || col is lower than zero || row is greater than or equal to rows || col is greater than or equal to cols || grid[row][col] is not equal to '1'
	 * 			continue
	 * 		end if
	 * 		
	 * 		grid[row][col] <- '2'
	 * 		
	 * 		queue offer(int array [ row minus one, col ])
	 * 		queue offer(int array [ row plus one, col ])
	 * 		queue offer(int array [ row, col minus one ])
	 * 		queue offer(int array [ row, col plus one ])
	 * end while
	 * */
	public void BFS_2(Queue<int[]> queue, char[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		
		while (!queue.isEmpty()) {
			int[] coordinate = queue.poll();																		// T : O(1)
			int row = coordinate[0];
			int col = coordinate[1];
			
			if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] != '1') { continue; }
			
			grid[row][col] = '2';
			
			queue.offer(new int[] { row - 1, col });																// ¡ô
			queue.offer(new int[] { row + 1, col });																// ¡õ
			queue.offer(new int[] { row, col - 1 });																// ¡ö
			queue.offer(new int[] { row, col + 1 });																// ¡÷
		}
	}
	
	/**
	 * time  : O(m * n)
	 * space : O(m * n)
	 * 
	 * int rows <- grid length
	 * int cols <- grid[0] length
	 * int islands <- 0
	 * 
	 * Queue<int[]> queue <- new LinkedList
	 * boolean[][] visited <- new boolean[rows][cols]
	 * 
	 * for int row <- 0; if row is lower than rows; row++
	 * 		for int col <- 0; if col is lower than cols; col++
	 * 			if visited[row][col] || grid[row][col] is equal to '0'
	 * 				continue
	 * 			end if
	 * 			
	 * 			queue offer(int array [row, col])
	 * 			visited[row][col] <- true
	 * 			
	 * 			BFS(queue, visited, grid)
	 * 			islands++
	 * 		end for
	 * end for
	 * 
	 * return islands
	 * */
	public int numIslands_3(char[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		int islands = 0;
		
		Queue<int[]> queue = new LinkedList<>();																	// S : O(m * n)
		boolean[][] visited = new boolean[rows][cols];																// S : O(m * n)
		
		for (int row = 0; row < rows; row++) {																		// T : O(m)
			for (int col = 0; col < cols; col++) {																	// T : O(n)
				if (visited[row][col] || grid[row][col] == '0') { continue; }
				
				queue.offer(new int[] { row, col });																// T : O(1)
				visited[row][col] = true;
				
				BFS_3(queue, visited, grid);
				islands++;
			}
		}
		
		return islands;
	}
	
	/**
	 * int rows <- grid length
	 * int cols <- grid[0] length
	 * int[][] directions <- [ [0,1], [1,0], [0,-1], [-1.0] ]
	 * 
	 * while queue is not empty
	 * 		int[] coordinate <- queue poll
	 * 		
	 * 		for int[] direction in directions
	 * 			int row <- coordinate[0] plus direction[0]
	 * 			int col <- coordinate[1] plus direction[1]
	 * 			
	 * 			if row is lower than zero || col is lower than zero || row is greater than or equal to rows || col is greater than or equal to cols || visited[row][col] is equal to true || grid[row][col] is equal to '0'
	 * 				continue
	 * 			end if
	 * 			
	 * 			visited[row][col] <- true
	 * 			queue offer(int array [row, col])
	 * 		end for
	 * end while
	 * */
	public void BFS_3(Queue<int[]> queue, boolean[][] visited, char[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		
		while (!queue.isEmpty()) {
			int[] coordinate = queue.poll();																		// T : O(1)
			
			for (int[] direction : directions) {
				int row = coordinate[0] + direction[0];
				int col = coordinate[1] + direction[1];
				
				if (row < 0 || col < 0 || row >= rows || col >= cols || visited[row][col] || grid[row][col] == '0') { continue; }
				
				visited[row][col] = true;
				queue.offer(new int[] { row, col });																// T : O(1)
			}
		}
	}
	
	/**
	 * time  : O(m * n)
	 * space : O(m * n)
	 * 
	 * Stack<int[]> stack <- new Stack
	 * int rows <- grid length
	 * int cols <- grid[0] length
	 * int islands <- 0
	 * 
	 * for int row <- 0; if row is lower than rows; row++
	 * 		for int col <- 0; if col is lower than cols; col++
	 * 			if grid[row][col] is not equal to '1'
	 * 				continue
	 * 			end if
	 * 			
	 * 			stack push(int array [row, col])
	 * 			DFS(stack, grid)
	 * 			islands++
	 * 		end for
	 * end for
	 * 
	 * return islands
	 * */
	public int numIslands_4(char[][] grid) {
		Stack<int[]> stack = new Stack<>();																			// T : O(m * n)
		int rows = grid.length;
		int cols = grid[0].length;
		int islands = 0;
		
		for (int row = 0; row < rows; row++) {																		// T : O(m)
			for (int col = 0; col < cols; col++) {																	// T : O(n)
				if (grid[row][col] != '1') { continue; }
				
				stack.push(new int[] { row, col });
				DFS_2(stack, grid);
				islands++;
			}
		}
		
		return islands;
	}
	
	/**
	 * int rows <- grid length
	 * int cols <- grid[0] length
	 * 
	 * while stack is not empty
	 * 		int coordinate <- stack pop
	 * 		int row <- coordinate[0]
	 * 		int col <- coordinate[1]
	 * 		
	 * 		if row is lower than zero || col is lower than zero || row is greater than or equal to rows || col is greater than or equal to cols || grid[row][col] is not equal to '1'
	 * 			continue
	 * 		end if
	 * 		
	 * 		gird[row][col] <- '2'
	 * 		
	 * 		stack push(int array [row minus one, col])
	 * 		stack push(int array [row plus one, col])
	 * 		stack push(int array [row, col minus one])
	 * 		stack push(int array [row, col plus one])
	 * end while
	 * */
	public void DFS_2(Stack<int[]> stack, char[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		
		while (!stack.isEmpty()) {
			int[] coordinate = stack.pop();
			int row = coordinate[0];
			int col = coordinate[1];
			
			if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] != '1') { continue; }
			
			grid[row][col] = '2';
			
			stack.push(new int[] { row - 1, col });
			stack.push(new int[] { row + 1, col });
			stack.push(new int[] { row, col - 1 });
			stack.push(new int[] { row, col + 1 });
		}
	}
	
	/**
	 * time  : O(m * n)
	 * space : O(1)
	 * 
	 * int rows <- grid length
	 * int cols <- grid[0] length
	 * int islands <- 0
	 * 
	 * for int row <- 0; if row is lower than rows; row++
	 * 		for int col <- 0; if col is lower than cols; col++
	 * 			if grid[row][col] is equal to '0'
	 * 				continue
	 * 			end if
	 * 			
	 * 			DFS(row, col, grid)
	 * 			islands++
	 * 		end for
	 * end for
	 * 
	 * return islands
	 * */
	public int numIslands(char[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		int islands = 0;
		
		for (int row = 0; row < rows; row++) {																		// T : O(m)
			for (int col = 0; col < cols; col++) {																	// T : O(n)
				if (grid[row][col] == '0') { continue; }
				
				DFS(row, col, grid);
				islands++;
			}
		}
		
		return islands;
	}
	
	/**
	 * int rows <- grid length
	 * int cols <- grid[0] length
	 * 
	 * if row is lower than zero || col is lower than zero || row is greater than or equal to rows || col is greater than or equal to cols || grid[row][col] is not equal to '0'
	 * 		return
	 * end if
	 * 
	 * grid[row][col] <- '0'
	 * 
	 * DFS(row minus one, col, grid)
	 * DFS(row plus one, col, grid)
	 * DFS(row, col minus one, grid)
	 * DFS(row, col plus one, grid)
	 * */
	public void DFS(int row, int col, char[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		
		if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == '0') { return; }
		
		grid[row][col] = '0';
		
		DFS(row - 1, col, grid);																					// ¡ô
		DFS(row + 1, col, grid);																					// ¡õ
		DFS(row, col - 1, grid);																					// ¡ö
		DFS(row, col + 1, grid);																					// ¡÷
	}
	
}
