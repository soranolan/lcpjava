package com.example.lcpjava.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lcp_997_Find_the_Town_Judge {
	
	/**
	 * time  : O(n + m)
	 * space : O(n)
	 * 
	 * Set<Integer> outDegree <- new HashSet
	 * Map<Integer, Integer> inDegree <- new HashMap
	 * 
	 * for int[] pair in trust
	 * 		outDegree add(pair[0])
	 * 		inDegree put(pair[1], inDegree getOrDefault(pair[1], zero) plus one)
	 * end for
	 * 
	 * for int judge <- 1; if judge is lower than or equal to n; judge++
	 * 		if outDegree does not contain judge && inDegree getOrDefault(judge, zero) is equal to n minus one
	 * 			return judge
	 * 		end if
	 * end for
	 * 
	 * return minus one
	 * */
	public int findJudge_1(int n, int[][] trust) {
		Set<Integer> outDegree = new HashSet<>();																	// S : O(n - 1)
		Map<Integer, Integer> inDegree = new HashMap<>();															// S : O(n)
		
		for (int[] pair : trust) {																					// T : O(m)
			outDegree.add(pair[0]);																					// T : O(1)
			inDegree.put(pair[1], inDegree.getOrDefault(pair[1], 0) + 1);											// T : O(1)
		}
		
		for (int judge = 1; judge <= n; judge++) {																	// T : O(n)
			if (!outDegree.contains(judge) && inDegree.getOrDefault(judge, 0) == n - 1) {							// T : O(1)
				return judge;
			}
		}
		
		return -1;
	}
	
	/**
	 * time  : O(n + m)
	 * space : O(n)
	 * 
	 * int[] outDegree <- new int[n plus one]
	 * int[] inDegree <- new int[n plus one]
	 * 
	 * for int[] pair in trust
	 * 		outDegree[pair[0]]++
	 * 		inDegree[pair[1]]++
	 * end for
	 * 
	 * for int judge <- 1; if judge is lower than or equal to n; judge++
	 * 		if judge's out-degree is equal to zero && judge's in-degree is equal to n minus one
	 * 			return judge
	 * 		end if
	 * end for
	 * 
	 * return minus one
	 * */
	public int findJudge_2(int n, int[][] trust) {
		int[] outDegree = new int[n + 1];																			// S : O(n + 1)
		int[] inDegree = new int[n + 1];																			// S : O(n + 1)
		
		for (int[] pair : trust) {																					// T : O(m)
			outDegree[pair[0]]++;
			inDegree[pair[1]]++;
		}
		
		for (int judge = 1; judge <= n; judge++) {																	// T : O(n)
			if (outDegree[judge] == 0 && inDegree[judge] == n - 1) {
				return judge;
			}
		}
		
		return -1;
	}
	
	/**
	 * time  : O(n + m)
	 * space : O(n)
	 * 
	 * int[] trusted <- new int[n plus one]
	 * 
	 * for int[] pair in trust
	 * 		trusted[pair[0]]--
	 * 		trusted[pair[1]]++
	 * end for
	 * 
	 * for int judge <- 1; if judge is lower than or equal to n; judge++
	 * 		if trusted[judge] is equal to n minus one
	 * 			return judge
	 * 		end if
	 * end for
	 * 
	 * return minus one
	 * */
	public int findJudge(int n, int[][] trust) {
		int[] trusted = new int[n + 1];																				// S : O(n + 1)
		
		for (int[] pair : trust) {																					// T : O(m)
			trusted[pair[0]]--;
			trusted[pair[1]]++;
		}
		
		for (int judge = 1; judge <= n; judge++) {																	// T : O(n)
			if (trusted[judge] == n - 1) {
				return judge;
			}
		}
		
		return -1;
	}
	
}
