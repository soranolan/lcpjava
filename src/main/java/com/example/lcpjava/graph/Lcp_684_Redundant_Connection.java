package com.example.lcpjava.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import com.example.lcpjava.common.UF_684;

public class Lcp_684_Redundant_Connection {
	
	/**
	 * time  : O(n ^ 2)
	 * space : O(n)
	 * 
	 * int[] result <- null
	 * int length <- edges length
	 * List<List<Integer>> graph <- new ArrayList<List<Integer>>(length plus one)
	 * 
	 * fill graph with empty ArrayList
	 * 
	 * for int[] edge in edges
	 * 		boolean[] visited <- new boolean[length plus one]
	 * 		
	 * 		if BFS(edge[0], edge[1], visited, graph) is true
	 * 			result <- edge
	 * 		end if
	 * 		
	 * 		graph get(edge[0]) add(edge[1])
	 * 		graph get(edge[1]) add(edge[0])
	 * end for
	 * 
	 * return result
	 * */
	public int[] findRedundantConnection_1(int[][] edges) {
		int[] result = null;
		int length = edges.length;
		List<List<Integer>> graph = new ArrayList<List<Integer>>(length + 1);										// S : O(n + 1)
		for (int i = 0; i < length + 1; i++) { graph.add(new ArrayList<>()); }										// T : O(n + 1)
		
		for (int[] edge : edges) {																					// T : O(n)
			// each time adding a new edge, we need to reset visited path
			boolean[] visited = new boolean[length + 1];															// S : O(n + 1)
			
			// check if adding the edge would create a cycle
			if (BFS(edge[0], edge[1], visited, graph)) { result = edge; }
			
			// remember the edge
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}
		
		return result;
	}
	
	/**
	 * Queue<Integer> queue <- new LinkedList
	 * queue offer(source)
	 * 
	 * while queue is not empty
	 * 		int current <- queue poll
	 * 		
	 * 		if current is equal to target
	 * 			return true
	 * 		end if
	 * 		
	 * 		visited[current] <- true
	 * 		
	 * 		for int next in graph get(current)
	 * 			if not visited[next]
	 * 				queue offer(next)
	 * 			end if
	 * 		end for
	 * end while
	 * 
	 * return false
	 * */
	public boolean BFS(int source, int target, boolean[] visited, List<List<Integer>> graph) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(source);
		
		while (!queue.isEmpty()) {
			int current = queue.poll();
			if (current == target) { return true; }
			visited[current] = true;
			
			for (int next : graph.get(current)) {
				if (!visited[next]) { queue.offer(next); }
			}
		}
		
		return false;
	}
	
	/**
	 * time  : O(n ^ 2)
	 * space : O(n)
	 * 
	 * int[] result <- null
	 * int length <- edges length
	 * List<List<Integer>> graph <- new ArrayList<List<Integer>>(length plus one)
	 * 
	 * fill graph with empty ArrayList
	 * 
	 * for int[] edge in edges
	 * 		boolean[] visited <- new boolean[length plus one]
	 * 		
	 * 		if DFS(edge[0], edge[1], visited, graph) is true
	 * 			result <- edge
	 * 		end if
	 * 		
	 * 		graph get(edge[0]) add(edge[1])
	 * 		graph get(edge[1]) add(edge[0])
	 * end for
	 * 
	 * return result
	 * */
	public int[] findRedundantConnection_2(int[][] edges) {
		int[] result = null;
		int length = edges.length;
		List<List<Integer>> graph = new ArrayList<List<Integer>>(length + 1);										// S : O(n + 1)
		for (int i = 0; i < length + 1; i++) { graph.add(new ArrayList<>()); }										// T : O(n + 1)
		
		for (int[] edge : edges) {																					// T : O(n)
			boolean[] visited = new boolean[length + 1];															// S : O(n + 1)
			
			if (DFS_1(edge[0], edge[1], visited, graph)) { result = edge; }
			
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}
		
		return result;
	}
	
	/**
	 * if visited[source] is true
	 * 		return false
	 * end if
	 * 
	 * visited[source] <- true
	 * 
	 * if source is equal to target
	 * 		return true
	 * end if
	 * 
	 * for int next in graph get(source)
	 * 		if DFS(next, target, visited, graph)
	 * 			return true
	 * 		end if
	 * end for
	 * 
	 * return false
	 * */
	public boolean DFS_1(int source, int target, boolean[] visited, List<List<Integer>> graph) {
		if (visited[source]) { return false; }
		visited[source] = true;
		
		if (source == target) { return true; }
		
		for (int next : graph.get(source)) {
			if (DFS_1(next, target, visited, graph)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/redundant-connection/discuss/1295887/Easy-Solution-w-Explanation-or-All-Possible-Approaches-with-comments
	 * 
	 * 
	 * int length <- edges length
	 * List<List<Integer>> graph <- new ArrayList<List<Integer>>(length plus one)
	 * 
	 * fill graph with empty ArrayList
	 * 
	 * boolean[] visited <- new boolean[length plus one]
	 * 
	 * for int[] edge in edges
	 * 		graph get(edge[0]) add(edge[1])
	 * 		graph get(edge[1]) add(edge[0])
	 * end for
	 * 
	 * DFS(one, minus one, graph, visited)
	 * 
	 * for int i <- length minus one; if i is greater than or equal to zero; i--
	 * 		if cycle contains(edges[i][0]) && cycle contains(edges[i][1])
	 * 			return edges[i]
	 * 		end if
	 * end for
	 * 
	 * return null
	 * */
	Set<Integer> cycle;
	int cycleStart;
	public int[] findRedundantConnection_3(int[][] edges) {
		cycle = new HashSet<>();
		cycleStart = -1;
		
		int length = edges.length;
		List<List<Integer>> graph = new ArrayList<List<Integer>>(length + 1);										// S : O(n + 1)
		for (int i = 0; i < length + 1; i++) { graph.add(new ArrayList<>()); }										// T : O(n + 1)
		boolean[] visited = new boolean[length + 1];																// S : O(n + 1)
		
		for (int[] edge : edges) {																					// T : O(n)
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}
		
		DFS(1, -1, graph, visited);
		
		for (int i = length - 1; i >= 0; i--) {																		// T : O(n)
			if (cycle.contains(edges[i][0]) && cycle.contains(edges[i][1])) {
				return edges[i];
			}
		}
		
		return null;
	}
	
	/**
	 * if visited[current]
	 * 		cycleStart <- current
	 * 		return
	 * end if
	 * 
	 * visited[current] <- true
	 * 
	 * for int next in graph get(current)
	 * 		if next is equal to parent
	 * 			continue
	 * 		end if
	 * 		
	 * 		if cycle is empty
	 * 			DFS(next, current, graph, visited)
	 * 		end if
	 * 		
	 * 		if cycleStart is not equal to minus one
	 * 			cycle add(current)
	 * 		end if
	 * 		
	 * 		if current is equal to cycleStart
	 * 			cycleStart <- minus one
	 * 			return
	 * 		end if
	 * end for
	 * */
	public void DFS(int current, int parent, List<List<Integer>> graph, boolean[] visited) {
		if (visited[current]) {																						// mark as start of cycle
			cycleStart = current;
			return;
		}
		visited[current] = true;
		
		for (int next : graph.get(current)) {
			if (next == parent) { continue; }																		// don't visit parent again
			if (cycle.isEmpty()) { DFS(next, current, graph, visited); }											// cycle not yet detected, explore graph further
			if (cycleStart != -1) { cycle.add(current); }															// cycle detected, keep pushing nodes till we reach start of the cycle
			if (current == cycleStart) {																			// all nodes of cycle taken
				cycleStart = -1;
				return;
			}
		}
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * int[] result <- null
	 * UnionFind uf <- new UnionFind(edges length plus one)
	 * 
	 * for int[] edge in edges
	 * 		if uf union(edge[0], edge[1]) is false
	 * 			result <- edge
	 * 		end if
	 * end for
	 * 
	 * return result
	 * */
	public int[] findRedundantConnection(int[][] edges) {
		int[] result = null;
		UF_684 uf = new UF_684(edges.length + 1);																	// T : O(n)
		
		for (int[] edge : edges) {																					// T : O(n)
			if (!uf.union(edge[0], edge[1])) { result = edge; }														// T : O(α(n))
		}
		
		return result;
	}
	
}
