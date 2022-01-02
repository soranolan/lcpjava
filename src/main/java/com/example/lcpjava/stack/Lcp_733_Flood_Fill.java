package com.example.lcpjava.stack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Lcp_733_Flood_Fill {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * int originalColor <- image[sr][sc]
	 * Set<String> visited <- new HashSet
	 * 
	 * DFS(image, sr, sc, newColor, originalColor, visited)
	 * return image
	 * */
	public int[][] floodFill_1(int[][] image, int sr, int sc, int newColor) {
		int originalColor = image[sr][sc];
		Set<String> visited = new HashSet<>();																		// S : O(n)
		
		DFS_1(image, sr, sc, newColor, originalColor, visited);
		return image;
	}
	
	/**
	 * int rows <- image length
	 * int cols <- image[0] length
	 * String coordinate <- sr plus "," plus sc
	 * 
	 * if sr is lower than zero || sr is greater than or equal to rows || sc is lower than zero || sc is greater than or equal to cols
	 * 		return
	 * end if
	 * 
	 * if visited contains(coordinate)
	 * 		return
	 * end if
	 * 
	 * if image[sr][sc] is not equal to originalColor
	 * 		return
	 * end if
	 * 
	 * if image[sr][sc] is equal to original color
	 * 		image[sr][sc] <- newColor
	 * end if
	 * 
	 * visited add(coordinate)
	 * 
	 * DFS(image, sr minus one, sc, newColor, originalColor, visited)
	 * DFS(image, sr plus one, sc, newColor, originalColor, visited)
	 * DFS(image, sr, sc minus one, newColor, originalColor, visited)
	 * DFS(image, sr, sc plus one, newColor, originalColor, visited)
	 * */
	public void DFS_1(int[][] image, int sr, int sc, int newColor, int originalColor, Set<String> visited) {
		int rows = image.length;
		int cols = image[0].length;
		String coordinate = sr + "," + sc;
		
		if (sr < 0 || sr >= rows || sc < 0 || sc >= cols) { return; }
		if (visited.contains(coordinate)) { return; }																// T : O(1)
		if (image[sr][sc] != originalColor) { return; }
		
		if (image[sr][sc] == originalColor) { image[sr][sc] = newColor; }
		
		visited.add(coordinate);																					// T : O(1)
		
		DFS_1(image, sr - 1, sc, newColor, originalColor, visited);
		DFS_1(image, sr + 1, sc, newColor, originalColor, visited);
		DFS_1(image, sr, sc - 1, newColor, originalColor, visited);
		DFS_1(image, sr, sc + 1, newColor, originalColor, visited);
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * int originalColor <- image[sr][sc]
	 * if originalColor is not equal to newColor
	 * 		Stack<int array> stack <- new Stack
	 * 		stack push(new int array [ sr, sc ])
	 * 		
	 * 		DFS(image, stack, originalColor, newColor)
	 * end if
	 * return image
	 * */
	public int[][] floodFill_2(int[][] image, int sr, int sc, int newColor) {
		int originalColor = image[sr][sc];
		if (originalColor != newColor) {
			Stack<int[]> stack = new Stack<>();																		// S : O(n)
			stack.push(new int[] { sr, sc });																		// T : O(1)
			
			DFS_2(image, stack, originalColor, newColor);
		}
		return image;
	}
	
	/**
	 * int rows <- image length
	 * int cols <- image[0] length
	 * 
	 * while stack is not empty
	 * 		int[] coordinate <- stack pop
	 * 		int sr <- coordinate[0]
	 * 		int sc <- coordinate[1]
	 * 		
	 * 		if sr is lower than zero || sr is greater than or equal to rows || sc is lower than zero || sc is greater than or equal to cols || image[sr][sc] is not equal to originalColor
	 * 			continue
	 * 		end if
	 * 		
	 * 		image[sr][sc] <- newColor
	 * 		
	 * 		stack push(new int array[ sr minus one, sc ])
	 * 		stack push(new int array[ sr plus one, sc ])
	 * 		stack push(new int array[ sr, sc minus one ])
	 * 		stack push(new int array[ sr, sc plus one ])
	 * end while
	 * */
	public void DFS_2(int[][] image, Stack<int[]> stack, int originalColor, int newColor) {
		int rows = image.length;
		int cols = image[0].length;
		
		while (!stack.isEmpty()) {																					// T : O(n)
			int[] coordinate = stack.pop();																			// T : O(1)
			int sr = coordinate[0];
			int sc = coordinate[1];
			
			if (sr < 0 || sr >= rows || sc < 0 || sc >= cols || image[sr][sc] != originalColor) { continue; }
			
			image[sr][sc] = newColor;
			
			stack.push(new int[] { sr - 1, sc });
			stack.push(new int[] { sr + 1, sc });
			stack.push(new int[] { sr, sc - 1 });
			stack.push(new int[] { sr, sc + 1 });
		}
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * int originalColor <- image[sr][sc]
	 * 
	 * if originalColor is not equal to newColor
	 * 		Queue<int array> queue <- new LinkedList
	 * 		queue offer(new int array[ sr, sc ])
	 * 		
	 * 		BFS(image, queue, originalColor, newColor)
	 * end if
	 * 
	 * return image
	 * */
	public int[][] floodFill_3(int[][] image, int sr, int sc, int newColor) {
		int originalColor = image[sr][sc];
		if (originalColor != newColor) {
			Queue<int[]> queue = new LinkedList<>();																// S : O(n)
			queue.offer(new int[] { sr, sc });																		// T : O(1)
			
			BFS(image, queue, originalColor, newColor);
		}
		return image;
	}
	
	/**
	 * int rows <- image length
	 * int cols <- image[0] length
	 * 
	 * while queue is not empty
	 * 		int[] coordinate <- queue poll
	 * 		int sr <- coordinate[0]
	 * 		int sc <- coordinate[1]
	 * 		
	 * 		if sr is lower than zero || sr is greater than or equal to rows || sc is lower than zero || sc is greater than or equal to cols || image[sr][sc] is not equal to originalColor
	 * 			continue
	 * 		end if
	 * 		
	 * 		image[sr][sc] <- newColor
	 * 		
	 * 		queue offer(new int array[ sr minus one, sc ])
	 * 		queue offer(new int array[ sr plus one, sc ])
	 * 		queue offer(new int array[ sr, sc minus one ])
	 * 		queue offer(new int array[ sr, sc plus one ])
	 * end while
	 * */
	public void BFS(int[][] image, Queue<int[]> queue, int originalColor, int newColor) {
		int rows = image.length;
		int cols = image[0].length;
		
		while (!queue.isEmpty()) {																					// T : O(n)
			int[] coordinate = queue.poll();																		// T : O(1)
			int sr = coordinate[0];
			int sc = coordinate[1];
			
			if (sr < 0 || sr >= rows || sc < 0 || sc >= cols || image[sr][sc] != originalColor) { continue; }
			
			image[sr][sc] = newColor;
			
			queue.offer(new int[] { sr - 1, sc });
			queue.offer(new int[] { sr + 1, sc });
			queue.offer(new int[] { sr, sc - 1 });
			queue.offer(new int[] { sr, sc + 1 });
		}
	}
	
	/**
	 * time  : O(n)
	 * 			for every pixels
	 * space : O(n)
	 * 			for implicit system stack
	 * 
	 * int originalColor <- image[sr][sc]
	 * 
	 * if originalColor is not equal to newColor
	 * 		DFS(image, sr, sc, originalColor, newColor)
	 * end if
	 * 
	 * return image
	 * */
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int originalColor = image[sr][sc];
		if (originalColor != newColor) { DFS(image, sr, sc, originalColor, newColor); }
		return image;
	}
	
	/**
	 * int rows <- image length
	 * int cols <- image[0] length
	 * 
	 * if sr is lower than zero || sr is greater than or equal to rows || sc is lower than zero || sc is greater than or equal to cols || image[sr][sc] is not equal to originalColor
	 * 		return
	 * end if
	 * 
	 * image[sr][sc] <- newColor
	 * 
	 * DFS(image, sr minus one, sc, originalColor, newColor)
	 * DFS(image, sr plus one, sc, originalColor, newColor)
	 * DFS(image, sr, sc minus one, originalColor, newColor)
	 * DFS(image, sr, sc plus one, originalColor, newColor)
	 * */
	public void DFS(int[][] image, int sr, int sc, int originalColor, int newColor) {
		int rows = image.length;
		int cols = image[0].length;
		
		if (sr < 0 || sr >= rows || sc < 0 || sc >= cols || image[sr][sc] != originalColor) { return; }
		
		image[sr][sc] = newColor;
		
		DFS(image, sr - 1, sc, originalColor, newColor);
		DFS(image, sr + 1, sc, originalColor, newColor);
		DFS(image, sr, sc - 1, originalColor, newColor);
		DFS(image, sr, sc + 1, originalColor, newColor);
	}
	
}
