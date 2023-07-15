package com.example.lcpjava.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.lcpjava.common.Lcp_212_TrieNode;

public class Lcp_212_Word_Search_II {
	
	/**
	 * time  : O(m * n * k * 4 ^ max length of a word)
	 * space : O(m * n * k)
	 * */
	public List<String> findWords_1(char[][] board, String[] words) {
		Set<String> result = new HashSet<>();
		int rows = board.length;
		int cols = board[0].length;
		
		for (String word : words) {																					// T : O(k)
			boolean[][] visited = new boolean[rows][cols];															// S : O(m * n)
			
			for (int row = 0; row < rows; row++) {																	// T : O(m)
				for (int col = 0; col < cols; col++) {																// T : O(n)
					dfs(row, col, board, 0, word, visited, result);
				}
			}
		}
		
		return new ArrayList<>(result);
	}
	
	private void dfs(int row, int col, char[][] board, int charIndex, String word, boolean[][] visited, Set<String> result) {
		int rows = board.length;
		int cols = board[0].length;
		
		if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || word.charAt(charIndex) != board[row][col]) {
			return;
		}
		
		if (charIndex == word.length() - 1) {
			result.add(word);
			return;
		}
		
		visited[row][col] = true;
		
		dfs(row - 1, col, board, charIndex + 1, word, visited, result);
		dfs(row + 1, col, board, charIndex + 1, word, visited, result);
		dfs(row, col - 1, board, charIndex + 1, word, visited, result);
		dfs(row, col + 1, board, charIndex + 1, word, visited, result);
		
		visited[row][col] = false;
	}
	
	/**
	 * time  : O(m * n * 4 ^ max length of a word)
	 * space : O(26 * max length of a word)
	 * 
	 * https://leetcode.com/problems/word-search-ii/solutions/59780/java-15ms-easiest-solution-100-00/
	 * */
	public List<String> findWords(char[][] board, String[] words) {
		List<String> result = new ArrayList<>();
		
		Lcp_212_TrieNode root = buildTrie(words);																	// T : O(k)
		
		int rows = board.length;
		int cols = board[0].length;
		
		for (int row = 0; row < rows; row++) {																		// T : O(m)
			for (int col = 0; col < cols; col++) {																	// T : O(n)
				dfs(row, col, board, root, result);
			}
		}
		
		return result;
	}
	
	private Lcp_212_TrieNode buildTrie(String[] words) {
		Lcp_212_TrieNode root = new Lcp_212_TrieNode();
		
		for (String word : words) {
			Lcp_212_TrieNode current = root;
			
			for (char c : word.toCharArray()) {
				int index = c - 'a';
				if (current.children[index] == null) {
					current.children[index] = new Lcp_212_TrieNode();
				}
				current = current.children[index];
			}
			
			current.word = word;
		}
		
		return root;
	}
	
	private void dfs(int row, int col, char[][] board, Lcp_212_TrieNode current, List<String> result) {
		int rows = board.length;
		int cols = board[0].length;
		
		if (row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] == '#' || current.children[board[row][col] - 'a'] == null) {
			return;
		}
		
		char originalChar = board[row][col];
		current = current.children[originalChar - 'a'];
		
		if (current.word != null) {
			result.add(current.word);
			current.word = null;
		}
		
		board[row][col] = '#';
		
		dfs(row - 1, col, board, current, result);
		dfs(row + 1, col, board, current, result);
		dfs(row, col - 1, board, current, result);
		dfs(row, col + 1, board, current, result);
		
		board[row][col] = originalChar;
	}
	
}
