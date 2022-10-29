package com.example.lcpjava.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Lcp_1079_Letter_Tile_Possibilities {
	
	/**
	 * time  : O(n ^ n)
	 * space : O(m)
	 * */
	public int numTilePossibilities_1(String tiles) {
		int[] count = new int[26];																					// S : O(26)
		for (char tile : tiles.toCharArray()) { count[tile - 'A']++; }												// T : O(n)
		
		int length = tiles.length();																				// n
		Set<String> result = new HashSet<>();																		// S : O(m)
		StringBuilder sb = new StringBuilder();																		// S : O(n)
		
		DFS(tiles, sb, length, count, result);
		
		return result.size();
	}
	
	private void DFS(String tiles, StringBuilder sb, int length, int[] count, Set<String> result) {
		if (length == 0) {
			result.add(sb.toString());
			return;
		}
		
		for (char tile : tiles.toCharArray()) {																		// T : O(n)
			if (count[tile - 'A'] == 0) { continue; }
			
			sb.append(tile);
			count[tile - 'A']--;
			
			result.add(sb.toString());																				// T : O(n)
			
			DFS(tiles, sb, length - 1, count, result);
			
			sb.setLength(sb.length() - 1);
			count[tile - 'A']++;
		}
	}
	
	/**
	 * time  : O(26 ^ n)
	 * space : O(n)
	 * 
	 * n : tiles length
	 * 
	 * https://leetcode.com/problems/letter-tile-possibilities/discuss/308284/Concise-java-solution
	 * https://leetcode.com/problems/letter-tile-possibilities/discuss/308284/Concise-java-solution/671561
	 * */
	public int numTilePossibilities_2(String tiles) {
		int[] count = new int[26];																					// S : O(26)
		
		for (char tile : tiles.toCharArray()) { count[tile - 'A']++; }												// T : O(n)
		
		return DFS(count);
	}
	
	private int DFS(int[] count) {
		int result = 0;
		
		for (int i = 0; i < 26; i++) {																				// T : O(26)
			if (count[i] == 0) { continue; }
			
			count[i]--;
			
			result++;
			
			result += DFS(count);
			
			count[i]++;
		}
		
		return result;
	}
	
	/**
	 * time  : O(n ^ n)
	 * space : O(n)
	 * 
	 * Accepted Solutions Runtime Distribution
	 * 
	 * https://leetcode.com/problems/letter-tile-possibilities/discuss/308323/java-1ms-simple-solution-which-combines-permutation-and-subset
	 * */
	public int numTilePossibilities(String tiles) {
		int n = tiles.length();
		
		char[] chars = tiles.toCharArray();																			// S : O(n)
		Arrays.sort(chars);																							// T : O(n log n)
		
		boolean[] visited = new boolean[n];																			// S : O(n)
		
		return DFS(chars, 0, visited);
	}
	
	private int DFS(char[] chars, int length, boolean[] visited) {
		if (length == chars.length) { return 0; }
		
		int result = 0;
		
		for (int i = 0; i < chars.length; i++) {																	// T : O(n)
			if (visited[i]) { continue; }
			
			// avoid duplicate, try dry run AAB
			if (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1]) { continue; }
			
			visited[i] = true;
			
			result++;
			
			result += DFS(chars, length + 1, visited);
			
			visited[i] = false;
		}
		
		return result;
	}
	
}
