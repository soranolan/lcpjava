package com.example.lcpjava.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lcp_1319_Number_of_Operations_to_Make_Network_Connected {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * if connections length plus one is lower than n
	 * 		return minus one
	 * end if
	 * 
	 * List<List<Integer>> graph <- new ArrayList<List<Integer>>(n)
	 * for int i <- 0; if i is lower than n; i++
	 * 		graph add(new ArrayList)
	 * end for
	 * 
	 * for int[] connection in connections
	 * 		graph get(connection[0]) add(connection[1]);
	 * 		graph get(connection[1]) add(connection[0]);
	 * end for
	 * 
	 * int groups <- 0
	 * Queue<Integer> queue <- new LinkedList
	 * boolean[] visited <- new boolean[n]
	 * 
	 * for int computer <- 0; if computer is lower than n; computer++
	 * 		if computer had been visited
	 * 			continue
	 * 		end if
	 * 		
	 * 		queue offer(computer)
	 * 		visited[computer] <- true
	 * 		
	 * 		while queue is not empty
	 * 			int com <- queue poll
	 * 			
	 * 			for int sub in graph get(com)
	 * 				if sub had been visited
	 * 					continue
	 * 				end if
	 * 				
	 * 				queue offer(sub)
	 * 				visited[sub] <- true
	 * 			end for
	 * 		end while
	 * 		
	 * 		groups++
	 * end for
	 * 
	 * return groups minus one
	 * */
	public int makeConnected_1(int n, int[][] connections) {
		if (connections.length + 1 < n) { return -1; }
		
		List<List<Integer>> graph = new ArrayList<List<Integer>>(n);												// S : O(n)
		for (int i = 0; i < n; i++) { graph.add(new ArrayList<>()); }												// T : O(n)
		
		for (int[] connection : connections) {																		// T : O(connections length)
			graph.get(connection[0]).add(connection[1]);
			graph.get(connection[1]).add(connection[0]);
		}
		
		int groups = 0;
		Queue<Integer> queue = new LinkedList<>();																	// S : O(n)
		boolean[] visited = new boolean[n];																			// S : O(n)
		
		for (int computer = 0; computer < n; computer++) {															// T : O(n)
			if (visited[computer]) { continue; }
			
			queue.offer(computer);																					// T : O(1)
			visited[computer] = true;
			
			while (!queue.isEmpty()) {
				int com = queue.poll();																				// T : O(1)
				
				for (int sub : graph.get(com)) {
					if (visited[sub]) { continue; }
					
					queue.offer(sub);																				// T : O(1)
					visited[sub] = true;
				}
			}
			
			groups++;
		}
		
		return groups - 1;																							// need groups - 1 cable to connect all computer
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * if connections length plus one is lower than n
	 * 		return minus one
	 * end if
	 * 
	 * List<List<Integer>> graph <- new ArrayList<List<Integer>>(n)
	 * for int i <- 0; if i is lower than n; i++
	 * 		graph add(new ArrayList)
	 * end for
	 * 
	 * for int[] connection in connections
	 * 		graph get(connection[0]) add(connection[1]);
	 * 		graph get(connection[1]) add(connection[0]);
	 * end for
	 * 
	 * int groups <- 0
	 * boolean[] visited <- new boolean[n]
	 * 
	 * for int computer <- 0; if computer is lower than n; computer++
	 * 		if computer had been visited
	 * 			continue
	 * 		end if
	 * 		
	 * 		DFS(computer, graph, visited)
	 * 		
	 * 		groups++
	 * end for
	 * 
	 * return groups minus one
	 * */
	public int makeConnected_2(int n, int[][] connections) {
		if (connections.length + 1 < n) { return -1; }
		
		List<List<Integer>> graph = new ArrayList<List<Integer>>(n);												// S : O(n)
		for (int i = 0; i < n; i++) { graph.add(new ArrayList<>()); }												// T : O(n)
		
		for (int[] connection : connections) {																		// T : O(connections length)
			graph.get(connection[0]).add(connection[1]);
			graph.get(connection[1]).add(connection[0]);
		}
		
		int groups = 0;
		boolean[] visited = new boolean[n];																			// S : O(n)
		
		for (int computer = 0; computer < n; computer++) {															// T : O(n)
			if (visited[computer]) { continue; }
			
			DFS(computer, graph, visited);
			groups++;
		}
		
		return groups - 1;
	}
	
	/**
	 * if computer had been visited
	 * 		continue
	 * end if
	 * 
	 * visited[computer] <- true
	 * 
	 * for int com in graph get(computer)
	 * 		DFS(com, graph, visited)
	 * end for
	 * */
	public void DFS(int computer, List<List<Integer>> graph, boolean[] visited) {
		if (visited[computer]) { return; }
		visited[computer] = true;
		
		for (int com : graph.get(computer)) { DFS(com, graph, visited); }
	}
	
	/**
	 * time  : O(connections length)
	 * space : O(n)
	 * 
	 * if connections length plus one is lower than n
	 * 		return minus one
	 * end if
	 * 
	 * UF_1319 uf <- new UF_1319(n)
	 * 
	 * for int[] connection in connections
	 * 		uf union(connection[0], connection[1])
	 * end for
	 * 
	 * return uf groups minus one
	 * */
	public int makeConnected(int n, int[][] connections) {
		if (connections.length + 1 < n) { return -1; }
		
		UF_1319 uf = new UF_1319(n);
		
		for (int[] connection : connections) {																		// T : O(connections length)
			uf.union(connection[0], connection[1]);																	// T : O(£\(n))
		}
		
		return uf.groups - 1;
	}
	
}
