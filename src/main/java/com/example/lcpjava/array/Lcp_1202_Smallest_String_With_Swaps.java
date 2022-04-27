package com.example.lcpjava.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.lcpjava.common.UnionFind;

public class Lcp_1202_Smallest_String_With_Swaps {
	
	/**
	 * build adjacents by pairs
	 * 
	 * traverse the adjacents, record character and index
	 * 
	 * return answer
	 * */
	/**
	 * time  : O(pairs + n log n)
	 * space : O(pairs + n)
	 * 
	 * int length <- s length
	 * 
	 * List<List<Integer>> adjacents <- new ArrayList<List<Integer>>(length)
	 * 
	 * fill adjacents with ArrayList
	 * 
	 * build(adjacents, pairs)
	 * 
	 * char[] answer <- new char[length]
	 * 
	 * boolean[] visited <- new boolean[length]
	 * 
	 * traverse(s, adjacents, visited, answer)
	 * 
	 * return new String(answer)
	 * */
	public String smallestStringWithSwaps_1(String s, List<List<Integer>> pairs) {
		int length = s.length();																					// n
		
		List<List<Integer>> adjacents = new ArrayList<List<Integer>>(length);										// S : O(n)
		for (int i = 0; i < length; i++) { adjacents.add(new ArrayList<>()); }										// T : O(n)
		build(adjacents, pairs);
		
		char[] answer = new char[length];																			// S : O(n)
		boolean[] visited = new boolean[length];																	// S : O(n)
		traverse(s, adjacents, visited, answer);
		
		return new String(answer);
	}
	
	/**
	 * for List<Integer> pair in pairs
	 * 		int from <- pair get(0)
	 * 		int to <- pair get(1)
	 * 		
	 * 		adjacents get(from) add(to)
	 * 		adjacents get(to) add(from)
	 * end for
	 * */
	public void build(List<List<Integer>> adjacents, List<List<Integer>> pairs) {
		for (List<Integer> pair : pairs) {																			// T : O(pairs)
			int from = pair.get(0);
			int to = pair.get(1);
			
			adjacents.get(from).add(to);
			adjacents.get(to).add(from);
		}
	}
	
	/**
	 * for int vertex <- 0; if vertext is lower than s length; vertex++
	 * 		if vertex has visited
	 * 			continue
	 * 		end if
	 * 		
	 * 		List<Character> characters <- new ArrayList
	 * 		List<Character> indices <- new ArrayList
	 * 		
	 * 		DFS(s, vertex, characters, indices, adjacents, visited)
	 * 		
	 * 		sort characters
	 * 		sort indices
	 * 		
	 * 		for int index <- 0; if index is lower than characters size; index++
	 * 			answer[indices get(index)] <- characters get(index)
	 * 		end for
	 * end for
	 * */
	public void traverse(String s, List<List<Integer>> adjacents, boolean[] visited, char[] answer) {
		for (int vertex = 0; vertex < s.length(); vertex++) {														// T : O(n)
			if (visited[vertex]) { continue; }
			
			List<Character> characters = new ArrayList<>();
			List<Integer> indices = new ArrayList<>();
			
			DFS(s, vertex, characters, indices, adjacents, visited);
			
			Collections.sort(characters);																			// T : O(n log n)
			Collections.sort(indices);																				// T : O(n log n)
			
			for (int index = 0; index < characters.size(); index++) { answer[indices.get(index)] = characters.get(index); }
		}
	}
	
	/**
	 * characters add(s charAt(vertex))
	 * indices add(vertex)
	 * 
	 * visited[vertex] <- true
	 * 
	 * for int adjacent in adjacents get(vertex)
	 * 		if adjacent has visited
	 * 			continue
	 * 		end if
	 * 		
	 * 		DFS(s, adjacent, characters, indices, adjacents, visited)
	 * end for
	 * */
	public void DFS(String s, int vertex, List<Character> characters, List<Integer> indices, List<List<Integer>> adjacents, boolean[] visited) {
		characters.add(s.charAt(vertex));
		indices.add(vertex);
		
		visited[vertex] = true;
		
		for (int adjacent : adjacents.get(vertex)) {
			if (visited[adjacent]) { continue; }
			
			DFS(s, adjacent, characters, indices, adjacents, visited);
		}
	}
	
	/**
	 * union all pairs
	 * 
	 * build root <-> vertex mapping by union
	 * 
	 * traverse mapping by root
	 * 
	 * return answer
	 * */
	/**
	 * time  : O(pairs * α(n) + n * α(n) + n log n)
	 * space : O(n)
	 * 
	 * int length <- s length
	 * 
	 * UnionFind uf <- new UnionFind(length)
	 * 
	 * for List<Integer> pair in pairs
	 * 		int from <- pair get(0)
	 * 		int to <- pair get(1)
	 * 		uf union(from, to)
	 * end for
	 * 
	 * Map<Integer, List<Integer>> root2Component <- new HashMap
	 * 
	 * for int vertex <- 0; if vertex is lower than length; vertex++
	 * 		int root <- uf find(vertex)
	 * 		
	 * 		if root2Component get(root) is equal to null
	 * 			root2Component put(root, new ArrayList)
	 * 		end if
	 * 		
	 * 		root2Component get(root) add(vertex)
	 * end for
	 * 
	 * char[] answer <- new char[length]
	 * 
	 * for List<Integer> vertexs in root2Component values
	 * 		List<Character> characters <- new ArrayList
	 * 		
	 * 		for int vertex in vertexs
	 * 			characters add(s charAt(vertex))
	 * 		end for
	 * 		
	 * 		sort characters
	 * 		
	 * 		for int index <- 0; if index is lower than characters size; index++
	 * 			answer[vertexs get(index)] <- characters get(index)
	 * 		end for
	 * end for
	 * 
	 * return new String(answer)
	 * */
	public String smallestStringWithSwaps_2(String s, List<List<Integer>> pairs) {
		int length = s.length();																					// n
		UnionFind uf = new UnionFind(length);																		// S : O(n)
		for (List<Integer> pair : pairs) {																			// T : O(pairs)
			int from = pair.get(0);
			int to = pair.get(1);
			uf.union(from, to);																						// T : O(α(n))
		}
		
		Map<Integer, List<Integer>> root2Component = new HashMap<>();												// S : O(n)
		for (int vertex = 0; vertex < length; vertex++) {															// T : O(n)
			int root = uf.find(vertex);																				// T : O(α(n))
			if (root2Component.get(root) == null) { root2Component.put(root, new ArrayList<>()); }					// T : O(1)
			root2Component.get(root).add(vertex);																	// T : O(1)
		}
		
		char[] answer = new char[length];																			// S : O(n)
		for (List<Integer> vertexs : root2Component.values()) {
			List<Character> characters = new ArrayList<>();
			for (int vertex : vertexs) { characters.add(s.charAt(vertex)); }
			
			Collections.sort(characters);																			// T : O(n log n)
			
			for (int index = 0; index < characters.size(); index++) { answer[vertexs.get(index)] = characters.get(index); }
		}
		
		return new String(answer);
	}
	
	/**
	 * time  : O(pairs * α(n) + n * α(n) + n log n)
	 * space : O(n)
	 * 
	 * int length <- s length
	 * 
	 * UnionFind uf <- new UnionFind(length)
	 * 
	 * for List<Integer> pair in pairs
	 * 		int from <- pair get(0)
	 * 		int to <- pair get(1)
	 * 		uf union(from, to)
	 * end for
	 * 
	 * Map<Integer, List<Integer>> root2Component <- new HashMap
	 * 
	 * for int vertex <- 0; if vertex is lower than length; vertex++
	 * 		int root <- uf find(vertex)
	 * 		
	 * 		if root2Component get(root) is equal to null
	 * 			root2Component put(root, new ArrayList)
	 * 		end if
	 * 		
	 * 		root2Component get(root) add(vertex)
	 * end for
	 * 
	 * char[] answer <- new char[length]
	 * 
	 * for List<Integer> vertexs in root2Component values
	 * 		int idx <- 0
	 * 		char[] arr <- new char[vertexs size]
	 * 		
	 * 		for int vertex in vertexs
	 * 			arr[idx] <- s charAt(vertex)
	 * 			idx++
	 * 		end for
	 * 		
	 * 		sort arr
	 * 		
	 * 		for int index <- 0; if index is lower than vertexs size; index++
	 * 			answer[vertexs get(index)] <- arr[index]
	 * 		end for
	 * end for
	 * 
	 * return new String(answer)
	 * */
	public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
		int length = s.length();
		UnionFind uf = new UnionFind(length);
		for (List<Integer> pair : pairs) {																			// T : O(pairs)
			int from = pair.get(0);
			int to = pair.get(1);
			uf.union(from, to);																						// T : O(α(n))
		}
		
		Map<Integer, List<Integer>> root2Component = new HashMap<>();												// S : O(n)
		for (int vertex = 0; vertex < length; vertex++) {															// T : O(n)
			int root = uf.find(vertex);																				// T : O(α(n))
			if (root2Component.get(root) == null) { root2Component.put(root, new ArrayList<>()); }					// T : O(1)
			root2Component.get(root).add(vertex);																	// T : O(1)
		}
		
		char[] answer = new char[length];																			// S : O(n)
		for (List<Integer> vertexs : root2Component.values()) {
			int idx = 0;
			char[] arr = new char[vertexs.size()];
			for (int vertex : vertexs) { arr[idx++] = s.charAt(vertex); }
			
			Arrays.sort(arr);																						// T : O(n log n)
			
			for (int index = 0; index < vertexs.size(); index++) { answer[vertexs.get(index)] = arr[index]; }
		}
		
		return new String(answer);
	}
	
}
