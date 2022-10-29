package com.example.lcpjava.array;

import java.util.HashSet;
import java.util.Set;

public class Lcp_1079_Letter_Tile_Possibilities {
	
	/**
	 * time  : O(n ^ n)
	 * space : O(log n)
	 * */
	public int numTilePossibilities_1(String tiles) {
		int[] count = new int[26];																					// S : O(26)
		for (char tile : tiles.toCharArray()) { count[tile - 'A']++; }												// T : O(n)
		
		int length = tiles.length();																				// n
		Set<String> result = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		
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
			
			result.add(sb.toString());
			
			DFS(tiles, sb, length - 1, count, result);
			
			sb.setLength(sb.length() - 1);
			count[tile - 'A']++;
		}
	}
	
	/**
	 * time  : O(26 ^ n)
	 * space : O(log n)
	 * 
	 * n : tiles length
	 * 
	 * https://leetcode.com/problems/letter-tile-possibilities/discuss/308284/Concise-java-solution
	 * https://leetcode.com/problems/letter-tile-possibilities/discuss/308284/Concise-java-solution/671561
	 * */
	public int numTilePossibilities(String tiles) {
		int[] count = new int[26];																					// S : O(26)
		
		for (char tile : tiles.toCharArray()) { count[tile - 'A']++; }												// T : O(n)
		
		return DFS(count);
	}
	
	private int DFS(int[] count) {
		int sum = 0;
		
		for (int i = 0; i < 26; i++) {
			if (count[i] == 0) { continue; }
			
			count[i]--;
			
			sum++;
			
			sum += DFS(count);
			
			count[i]++;
		}
		
		return sum;
	}
	
}
