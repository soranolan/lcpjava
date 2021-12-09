package com.example.lcpjava.queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Lcp_841_Keys_and_Rooms {
	
	/**
	 * time  : O(m + n)
	 * space : O(m + n)
	 * 
	 * BFS
	 * 
	 * int roomSize <- rooms size
	 * Queue<Integer> queue <- new LinkedList
	 * Set<Integer> visited <- new HashSet
	 * 
	 * List<Integer> keys <- rooms get(0)
	 * visited add(0)
	 * 
	 * for Integer key in keys
	 * 		queue offer(key)
	 * end for
	 * 
	 * while queue is not empty
	 * 		int key <- queue poll()
	 * 		
	 * 		if visited contains key
	 * 			continue
	 * 		end if
	 * 		
	 * 		visited add(key)
	 * 		
	 * 		List<Integer> nextKeys <- rooms get(key)
	 * 		for	Integer nextKey in nextKeys
	 * 			queue offer(nextKey)
	 * 		end for
	 * end while
	 * 
	 * return if visited size is equal to roomSize then true else false
	 * */
	public boolean canVisitAllRooms_1(List<List<Integer>> rooms) {
		int roomSize = rooms.size();
		Queue<Integer> queue = new LinkedList<>();																	// S : O(m)
		Set<Integer> visited = new HashSet<>();																		// S : O(n)
		
		List<Integer> keys = rooms.get(0);
		visited.add(0);
		
		for (Integer key : keys) { queue.offer(key); }
		
		while (!queue.isEmpty()) {																					// T : O(m + n)
			Integer key = queue.poll();
			if (visited.contains(key)) { continue; }
			visited.add(key);
			
			List<Integer> nextKeys = rooms.get(key);
			for (Integer nextKey : nextKeys) { queue.offer(nextKey); }
		}
		
		return visited.size() == roomSize;
	}
	
	/**
	 * time  : O(m + n)
	 * space : O(m + n)
	 * 
	 * int roomSize <- rooms size
	 * int[] visited <- new int[roomSize]
	 * 
	 * DFS(0, rooms, visited)
	 * 
	 * for int v in visited
	 * 		if v is equal to zero
	 * 			return false
	 * 		end if
	 * end for
	 * 
	 * return true
	 * */
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		int roomSize = rooms.size();
		int[] visited = new int[roomSize];																			// S : O(n)
		
		DFS(0, rooms, visited);
		
		for (int v : visited) {																						// T : O(n)
			if (v == 0) { return false; }
		}
		
		return true;
	}
	
	/**
	 * visited[key] <- 1
	 * for Integer nextKey : rooms get(key)
	 * 		if visited[nextKey] is equal to one
	 * 			continue
	 * 		end if
	 * 		DFS(nextKey, rooms, visited)
	 * end for
	 * */
	public void DFS(int key, List<List<Integer>> rooms, int[] visited) {
		visited[key] = 1;
		for (Integer nextKey : rooms.get(key)) {																	// T : O(m)
			if (visited[nextKey] == 1) { continue; }
			DFS(nextKey, rooms, visited);
		}
	}
	
}
