package com.example.lcpjava.graph;

import java.util.LinkedList;
import java.util.Queue;

import com.example.lcpjava.common.UF_547;

public class Lcp_547_Number_of_Provinces {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * int provinces <- 0
	 * int length <- isConnected length
	 * Queue<Integer> queue <- new LinkedList
	 * boolean[] visited <- new boolean[length]
	 * 
	 * for int city <- 0; if city is lower than length; city++
	 * 		if city had been visited
	 * 			continue
	 * 		end if
	 * 		
	 * 		queue offer(city)
	 * 		visited[city] <- true
	 * 		
	 * 		while queue is not empty
	 * 			int fromCity <- queue poll
	 * 			
	 * 			for int toCity <- 0; if toCity is lower than length; toCity++
	 * 				if isConnected[fromCity][toCity] is equal to one && does not visited toCity
	 * 					queue add(toCity)
	 * 					visited[toCity] <- true
	 * 				end if
	 * 			end for
	 * 		end while
	 * 		
	 * 		provinces++
	 * end for
	 * 
	 * return provinces
	 * */
	public int findCircleNum_1(int[][] isConnected) {
		int provinces = 0;
		int length = isConnected.length;
		Queue<Integer> queue = new LinkedList<>();																	// S : O(n)
		boolean[] visited = new boolean[length];																	// S : O(n)
		
		for (int city = 0; city < length; city++) {																	// T : O(n)
			if (visited[city]) { continue; }
			
			queue.offer(city);
			visited[city] = true;
			
			while (!queue.isEmpty()) {
				int fromCity = queue.poll();
				
				for (int toCity = 0; toCity < length; toCity++) {
					if (isConnected[fromCity][toCity] == 1 && !visited[toCity]) {
						queue.add(toCity);
						visited[toCity] = true;
					}
				}
			}
			
			provinces++;
		}
		
		return provinces;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * int provinces <- 0
	 * int length <- isConnected length
	 * boolean[] visited <- new boolean[length]
	 * 
	 * for int fromCity <- 0; if fromCity is lower than length; fromCity++
	 * 		if does not visited fromCity
	 * 			DFS(fromCity, visited, isConnected)
	 * 			provinces++
	 * 		end if
	 * end for
	 * 
	 * return provinces
	 * */
	public int findCircleNum_2(int[][] isConnected) {
		int provinces = 0;
		int length = isConnected.length;
		boolean[] visited = new boolean[length];																	// S : O(n)
		
		for (int fromCity = 0; fromCity < length; fromCity++) {														// T : O(n)
			if (!visited[fromCity]) {
				DFS(fromCity, visited, isConnected);
				provinces++;
			}
		}
		
		return provinces;
	}
	
	/**
	 * for int toCity <- 0; if toCity is lower than isConnected length; toCity++
	 * 		if isConnected[fromCity][toCity] is equal to one && does not visited toCity
	 * 			visited[toCity] <- true
	 * 			DFS(toCity, visited, isConnected)
	 * 		end if
	 * end for
	 * */
	public void DFS(int fromCity, boolean[] visited, int[][] isConnected) {
		for (int toCity = 0; toCity < isConnected.length; toCity++) {												// T : O(n)
			if (isConnected[fromCity][toCity] == 1 && !visited[toCity]) {
				visited[toCity] = true;
				DFS(toCity, visited, isConnected);
			}
		}
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * int length <- isConnected length
	 * 
	 * UF_547 uf <- new UF_547(length)
	 * 
	 * for int fromCity <- 0; if fromCity is lower than length minus one; fromCity++
	 * 		for int toCity <- fromCity plus one; if toCity is lower than length; toCity++
	 * 			if isConnect[fromCity][toCity] is equal to one
	 * 				uf union(fromCity, toCity)
	 * 			end if
	 * 		end for
	 * end for
	 * 
	 * return uf provinces
	 * */
	public int findCircleNum(int[][] isConnected) {
		int length = isConnected.length;
		
		UF_547 uf = new UF_547(length);
		
		for (int fromCity = 0; fromCity < length - 1; fromCity++) {													// T : O(n - 1)
			for (int toCity = fromCity + 1; toCity < length; toCity++) {
				if (isConnected[fromCity][toCity] == 1) {
					uf.union(fromCity, toCity);																		// T : O(α(n))
				}
			}
		}
		
		return uf.provinces();
	}
	
}
