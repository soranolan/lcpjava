package com.example.lcpjava.array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Lcp_749_Contain_Virus {
	
	/**
	 * time  : O(regions * m * n)
	 * space : O(regions * m * n)
	 * 
	 * https://leetcode.com/problems/contain-virus/discuss/526848/Java-DFS-9-ms-Explanation-with-comments
	 * 
	 * 
	 * int rows <- isInfected length
	 * int cols <- isInfected[0] length
	 * int walls <- 0
	 * 
	 * while is true
	 * 		List<Region> regions <- new ArrayList
	 * 		boolean[][] visited <- new boolean[rows][cols]
	 * 		
	 * 		for int row <- 0; if row is lower than rows; row++
	 * 			for int col <- 0; if col is lower than cols; col++
	 * 				if isInfected[row][col] is not equal to one || visited[row][col] is true
	 * 					continue
	 * 				end if
	 * 				
	 * 				Region region <- new Region
	 * 				
	 * 				DFS(row, col, isInfected, visited, region)
	 * 				
	 * 				if region uninfected is empty
	 * 					continue
	 * 				end if
	 * 				
	 * 				regions add(region)
	 * 			end for
	 * 		end for
	 * 		
	 * 		if regions size is equal to zero
	 * 			break
	 * 		end if
	 * 		
	 * 		regions sort by uninfected size
	 * 		
	 * 		Region firstPriority <- regions remove first
	 * 		
	 * 		walls <- walls plus firstPriority wallsRequired
	 * 		
	 * 		disInfect(cols, isInfected, firstPriority)
	 * 		spreadOut(cols, isInfected, regions)
	 * end while
	 * 
	 * return walls
	 * */
	public int containVirus_1(int[][] isInfected) {
		int rows = isInfected.length;																				// m
		int cols = isInfected[0].length;																			// n
		int walls = 0;
		
		while (true) {																								// T : O(regions)
			List<Region> regions = new ArrayList<>();																// S : O(regions)
			boolean[][] visited = new boolean[rows][cols];															// S : O(m * n)
			
			for (int row = 0; row < rows; row++) {																	// T : O(m)
				for (int col = 0; col < cols; col++) {																// T : O(n)
					if (isInfected[row][col] != 1 || visited[row][col]) { continue; }
					
					Region region = new Region();
					DFS(row, col, isInfected, visited, region);
					if (region.uninfected.isEmpty()) { continue; }
					
					regions.add(region);
				}
			}
			
			if (regions.size() == 0) { break; }
			
			regions.sort(new Comparator<Region>() {																	// T : O(regions log regions)
				@Override
				public int compare(Region o1, Region o2) {
					return o2.uninfected.size() - o1.uninfected.size();
				}
			});
			
			Region firstPriority = regions.remove(0);																// T : O(regions)
			
			walls += firstPriority.wallsRequired;
			
			disInfect(cols, isInfected, firstPriority);
			spreadOut(cols, isInfected, regions);
		}
		
		return walls;
	}
	
	/**
	 * time  : O(regions * m * n)
	 * space : O(regions * m * n)
	 * 
	 * int rows <- isInfected length
	 * int cols <- isInfected[0] length
	 * int walls <- 0
	 * 
	 * while is true
	 * 		Queue<Region> maxHeap <- new PriorityQueue<>((offer, previous) -> previous uninfected size minus offer uninfected size)
	 * 		boolean[][] visited <- new boolean[rows][cols]
	 * 		
	 * 		for int row <- 0; if row is lower than rows; row++
	 * 			for int col <- 0; if col is lower than cols; col++
	 * 				if isInfected[row][col] is not equal to one || visited[row][col] is true
	 * 					continue
	 * 				end if
	 * 				
	 * 				Region region <- new Region
	 * 				
	 * 				DFS(row, col, isInfected, visited, region)
	 * 				
	 * 				if region uninfected is empty
	 * 					continue
	 * 				end if
	 * 				
	 * 				maxHeap offer(region)
	 * 			end for
	 * 		end for
	 * 		
	 * 		if maxHeap size is equal to zero
	 * 			break
	 * 		end if
	 * 		
	 * 		Region firstPriority <- maxHeap poll
	 * 		
	 * 		walls <- walls plus firstPriority wallsRequired
	 * 		
	 * 		disInfect(cols, isInfected, firstPriority)
	 * 		spreadOut(cols, isInfected, regions)
	 * end while
	 * 
	 * return walls
	 * */
	public int containVirus_2(int[][] isInfected) {
		int rows = isInfected.length;																				// m
		int cols = isInfected[0].length;																			// n
		int walls = 0;
		
		while (true) {																								// T : O(regions)
			Queue<Region> maxHeap = new PriorityQueue<>(
					(offer, previous) -> previous.uninfected.size() - offer.uninfected.size());						// S : O(regions)
			boolean[][] visited = new boolean[rows][cols];															// S : O(m * n)
			
			for (int row = 0; row < rows; row++) {																	// T : O(m)
				for (int col = 0; col < cols; col++) {																// S : O(n)
					if (isInfected[row][col] != 1 || visited[row][col]) { continue; }
					
					Region region = new Region();
					DFS(row, col, isInfected, visited, region);
					if (region.uninfected.isEmpty()) { continue; }
					
					maxHeap.offer(region);																			// T : O(log regions)
				}
			}
			
			if (maxHeap.size() == 0) { break; }
			
			Region firstPriority = maxHeap.poll();																	// T : O(1)
			
			walls += firstPriority.wallsRequired;
			
			disInfect(cols, isInfected, firstPriority);
			spreadOut(cols, isInfected, maxHeap);
		}
		
		return walls;
	}
	
	/**
	 * time  : O(regions * m * n)
	 * space : O(regions * m * n)
	 * 
	 * int rows <- isInfected length
	 * int cols <- isInfected[0] length
	 * int walls <- 0
	 * 
	 * while is true
	 * 		List<Region> regions <- new ArrayList
	 * 		boolean[][] visited <- new boolean[rows][cols]
	 * 		Region firstPriority <- new Region
	 * 		
	 * 		for int row <- 0; if row is lower than rows; row++
	 * 			for int col <- 0; if col is lower than cols; col++
	 * 				if isInfected[row][col] is not equal to one || visited[row][col] is true
	 * 					continue
	 * 				end if
	 * 				
	 * 				Region region <- new Region
	 * 				
	 * 				DFS(row, col, isInfected, visited, region)
	 * 				
	 * 				if region uninfected is empty
	 * 					continue
	 * 				end if
	 * 				
	 * 				regions add(region)
	 * 				
	 * 				if firstPriority uninfected size is greater than region uninfected size
	 * 					continue
	 * 				end if
	 * 				
	 * 				firstPriority isUnderControlled <- false
	 * 				firstPriority <- region
	 * 				firstPriority isUnderControlled <- true
	 * 			end for
	 * 		end for
	 * 		
	 * 		if regions size is equal to zero
	 * 			break
	 * 		end if
	 * 		
	 * 		walls <- walls plus firstPriority wallsRequired
	 * 		
	 * 		disInfect(cols, isInfected, firstPriority)
	 * 		spreadOut(cols, isInfected, regions)
	 * end while
	 * 
	 * return walls
	 * */
	public int containVirus(int[][] isInfected) {
		int rows = isInfected.length;																				// m
		int cols = isInfected[0].length;																			// n
		int walls = 0;
		
		while (true) {																								// T : O(regions)
			List<Region> regions = new ArrayList<>();																// S : O(regions)
			boolean[][] visited = new boolean[rows][cols];															// S : O(m * n)
			Region firstPriority = new Region();
			
			for (int row = 0; row < rows; row++) {																	// T : O(m)
				for (int col = 0; col < cols; col++) {																// T : O(n)
					if (isInfected[row][col] != 1 || visited[row][col]) { continue; }
					
					Region region = new Region();
					DFS(row, col, isInfected, visited, region);
					if (region.uninfected.isEmpty()) { continue; }
					
					regions.add(region);
					if (firstPriority.uninfected.size() > region.uninfected.size()) { continue; }
					
					firstPriority.isUnderControlled = false;														// previous
					firstPriority = region;
					firstPriority.isUnderControlled = true;															// current
				}
			}
			
			if (regions.size() == 0) { break; }
			
			walls += firstPriority.wallsRequired;
			
			disInfect(cols, isInfected, firstPriority);
			spreadOut(cols, isInfected, regions);
		}
		
		return walls;
	}
	
	/**
	 * int rows <- isInfected length
	 * int cols <- isInfected[0] length
	 * 
	 * if row is lower than zero || row is greater than or equal to rows || col is lower than zero || col is greater than or equal to cols || isInfected[row][col] is equal to two
	 * 		return
	 * end if
	 * 
	 * int coordinate <- row times cols plus col
	 * 
	 * if isInfected[row][col] is equal to one
	 * 		region infected add(coordinate)
	 * 		
	 * 		if visited[row][col]
	 * 			return
	 * 		end if
	 * end if
	 * 
	 * visited[row][col] <- true
	 * 
	 * if isInfected[row][col] is equal to zero
	 * 		region uninfected add(coordinate)
	 * 		region wallsRequired++
	 * 		return
	 * end if
	 * 
	 * DFS(row - 1, col, isInfected, visited, region)
	 * DFS(row + 1, col, isInfected, visited, region)
	 * DFS(row, col - 1, isInfected, visited, region)
	 * DFS(row, col + 1, isInfected, visited, region)
	 * */
	public void DFS(int row, int col, int[][] isInfected, boolean[][] visited, Region region) {
		int rows = isInfected.length;
		int cols = isInfected[0].length;
		
		if (row < 0 || row >= rows || col < 0 || col >= cols || isInfected[row][col] == 2) { return; }
		
		int coordinate = row * cols + col;
		
		if (isInfected[row][col] == 1) {
			region.infected.add(coordinate);
			if (visited[row][col]) { return; }
		}
		
		visited[row][col] = true;
		
		if (isInfected[row][col] == 0) {
			region.uninfected.add(coordinate);
			region.wallsRequired++;
			return;
		}
		
		DFS(row - 1, col, isInfected, visited, region);																// ↑
		DFS(row + 1, col, isInfected, visited, region);																// ↓
		DFS(row, col - 1, isInfected, visited, region);																// ←
		DFS(row, col + 1, isInfected, visited, region);																// →
	}
	
	/**
	 * assign(cols, isInfected, firstPriority infected, two)
	 * */
	public void disInfect(int cols, int[][] isInfected, Region firstPriority) {
		assign(cols, isInfected, firstPriority.infected, 2);
	}
	
	/**
	 * for Region region in regions
	 * 		if region isUnderControlled is true
	 * 			continue
	 * 		end if
	 * 		
	 * 		assign(cols, isInfected, region uninfected, one)
	 * end for
	 * */
	public void spreadOut(int cols, int[][] isInfected, Collection<Region> regions) {
		for (Region region : regions) {
			if (region.isUnderControlled) { continue; }
			assign(cols, isInfected, region.uninfected, 1);
		}
	}
	
	/**
	 * for int coordinate in area
	 * 		int row <- coordinate divide by cols
	 * 		int col <- coordinate modulo cols
	 * 		isInfected[row][col] <- value
	 * end for
	 * */
	public void assign(int cols, int[][] isInfected, Set<Integer> area, int value) {
		for (int coordinate : area) {
			int row = coordinate / cols;
			int col = coordinate % cols;
			isInfected[row][col] = value;
		}
	}
	
}
