package com.example.lcpjava.trie;

import com.example.lcpjava.common.Lcp_211_TrieNode;

// https://leetcode.com/problems/design-add-and-search-words-data-structure/solutions/3313638/java-c-simple-solution-easy-to-understand/
// Accepted Solutions Runtime Distribution
public class WordDictionary {
	
	private Lcp_211_TrieNode root;
	
	public WordDictionary() {
		root = new Lcp_211_TrieNode();
	}
	
	/**
	 * n : word length
	 * 
	 * time  : O(n)
	 * space : O(n)
	 * */
	public void addWord(String word) {
		Lcp_211_TrieNode current = root;
		
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (current.children[index] == null) {
				current.children[index] = new Lcp_211_TrieNode();
			}
			current = current.children[index];
		}
		
		current.isEnd = true;
	}
	
	public boolean search(String word) {
		return search(root, word.toCharArray(), 0);
	}
	
	/**
	 * n : word length
	 * 
	 * time  : O(n)
	 * space : O(n)
	 * */
	private boolean search(Lcp_211_TrieNode root, char[] word, int index) {
		if (index >= word.length) {
			return root.isEnd;
		}
		
		Lcp_211_TrieNode current = root;
		
		char c = word[index];
		
		if (c == '.') {
			for (Lcp_211_TrieNode child : current.children) {
				if (child != null && search(child, word, index + 1)) {
					return true;
				}
			}
			return false;
		}
		
		int i = c - 'a';
		Lcp_211_TrieNode child = current.children[i];
		if (child == null) {
			return false;
		}
		return search(child, word, index + 1);
	}
	
}
