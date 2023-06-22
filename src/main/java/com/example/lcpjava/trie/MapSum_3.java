package com.example.lcpjava.trie;

import com.example.lcpjava.common.Lcp_677_TrieNode_1;

// Accepted Solutions Runtime Distribution
public class MapSum_3 {
	
	private Lcp_677_TrieNode_1 root;
	
	public MapSum_3() {
		root = new Lcp_677_TrieNode_1();
	}
	
	/**
	 * n : key length
	 * 
	 * time  : O(n)
	 * space : O(n)
	 * */
	public void insert(String key, int val) {
		Lcp_677_TrieNode_1 current = root;
		
		for (int i = 0; i < key.length(); i++) {
			int index = key.charAt(i) - 'a';
			if (current.children[index] == null) {
				current.children[index] = new Lcp_677_TrieNode_1();
			}
			current = current.children[index];
			current.sum += val;
		}
		
		if (current.isWord) {
			current.isWord = false;
			insert(key, current.value * -1);																		// T : O(n)
		}
		
		current.value = val;
		current.isWord = true;
	}
	
	/**
	 * n : prefix length
	 * 
	 * time  : O(n)
	 * space : O(1)
	 * */
	public int sum(String prefix) {
		Lcp_677_TrieNode_1 current = root;
		
		for (int i = 0; i < prefix.length(); i++) {
			int index = prefix.charAt(i) - 'a';
			if (current.children[index] == null) {
				return 0;
			}
			current = current.children[index];
		}
		
		return current.sum;
	}
	
}
