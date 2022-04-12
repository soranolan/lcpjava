package com.example.lcpjava.graph;

import java.util.LinkedList;
import java.util.Queue;

import com.example.lcpjava.common.UnionFind;

public class Lcp_785_Is_Graph_Bipartite {
	
	/**
	 * time  : O(edge + n)
	 * space : O(n)
	 * 
	 * int length <- graph length
	 * int[] colors <- new int[length]
	 * Queue<Integer> queue <- new LinkedList
	 * 
	 * for int node <- 0; if node is lower than length; node++
	 * 		if colors[node] is not equal to zero
	 * 			continue
	 * 		end if
	 * 		
	 * 		colors[node] <- 1
	 * 		queue offer(node)
	 * 		
	 * 		while queue is not empty
	 * 			int current <- queue poll
	 * 			
	 * 			for int next in graph[current]
	 * 				if colors[next] is equal to zero
	 * 					colors[next] <- minus colors[current]
	 * 					queue offer(next)
	 * 				else if colors[next] is not equal to minus colors[current]
	 * 					return false
	 * 				end if
	 * 			end for
	 * 		end while
	 * end for
	 * 
	 * return true
	 * */
	public boolean isBipartite_1(int[][] graph) {
		int length = graph.length;
		
		// 0 : default, 1 : red, -1 : black
		int[] colors = new int[length];																				// S : O(n)
		Queue<Integer> queue = new LinkedList<>();																	// S : O(n)
		
		for (int node = 0; node < length; node++) {																	// T : O(n)
			if (colors[node] != 0) { continue; }
			
			colors[node] = 1;
			queue.offer(node);
			
			while (!queue.isEmpty()) {
				int current = queue.poll();
				
				for (int next : graph[current]) {
					if (colors[next] == 0) {
						colors[next] = -colors[current];
						queue.offer(next);
					} else if (colors[next] != -colors[current]) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	/**
	 * time  : O(edge + n)
	 * space : O(n)
	 * 
	 * int length <- graph length
	 * int[] colors <- new int[length]
	 * 
	 * for int node <- 0; if node is lower than length; node++
	 * 		if colors[node] is not equal to zero
	 * 			continue
	 * 		end if
	 * 		
	 * 		if is not validColor(node, one, colors, graph)
	 * 			return false
	 * 		end if
	 * end for
	 * 
	 * return true
	 * */
	public boolean isBipartite_2(int[][] graph) {
		int length = graph.length;
		
		// 0 : default, 1 : red, -1 : black
		int[] colors = new int[length];																				// S : O(n)
		
		for (int node = 0; node < length; node++) {																	// T : O(n)
			if (colors[node] != 0) { continue; }
			if (!validColor(node, 1, colors, graph)) { return false; }
		}
		
		return true;
	}
	
	/**
	 * if colors[node] is not equal to zero
	 * 		return if colors[node] is equal to color
	 * end if
	 * 
	 * colors[node] <- color
	 * 
	 * for int next in graph[node]
	 * 		if is not validColor(next, minus color, colors, graph)
	 * 			return false
	 * 		end if
	 * end for
	 * 
	 * return true
	 * */
	public boolean validColor(int node, int color, int[] colors, int[][] graph) {
		if (colors[node] != 0) { return colors[node] == color; }
		colors[node] = color;
		
		for (int next : graph[node]) {
			if (!validColor(next, -color, colors, graph)) { return false; }
		}
		
		return true;
	}
	
	/**
	 * time  : O(edge + n)
	 * space : O(n)
	 * 
	 * int length <- graph length
	 * 
	 * UnionFind uf <- new UnionFind(length)
	 * 
	 * for int node <- 0; if node is lower than length; node++
	 * 		int[] next <- graph[node]
	 * 		
	 * 		for int i <- 0; if i is lower than next length; i++
	 * 			if uf find(node) is equal to uf find(next[i])
	 * 				return false
	 * 			end if
	 * 			
	 * 			uf union(next[0], next[i])
	 * 		end for
	 * end for
	 * 
	 * return true
	 * */
	public boolean isBipartite(int[][] graph) {
		int length = graph.length;
		UnionFind uf = new UnionFind(length);																		// S : O(n)
		
		for (int node = 0; node < length; node++) {																	// T : O(n)
			int[] next = graph[node];
			
			for (int i = 0; i < next.length; i++) {
				if (uf.find(node) == uf.find(next[i])) { return false; }											// T : O(α(n))
				uf.union(next[0], next[i]);																			// T : O(α(n))
			}
		}
		
		return true;
	}
	
}
