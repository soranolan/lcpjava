package com.example.lcpjava.trie;

import com.example.lcpjava.common.Lcp_677_TrieNode;

public class MapSum_1 {
	
	Lcp_677_TrieNode root;
	
	public MapSum_1() {
		root = new Lcp_677_TrieNode();
	}
	
	/**
	 * n : key length
	 * 
	 * time  : O(n)
	 * space : O(n)
	 * */
	public void insert(String key, int val) {
		Lcp_677_TrieNode current = root;
		
		for (int i = 0; i < key.length(); i++) {
			int index = key.charAt(i) - 'a';
			if (current.children[index] == null) {
				current.children[index] = new Lcp_677_TrieNode();
			}
			current = current.children[index];
		}
		
		current.value = val;
	}
	
	/**
	 * n : prefix length
	 * m : nodes
	 * 
	 * time  : O(n + m)
	 * space : O(m)
	 * */
	public int sum(String prefix) {
		Lcp_677_TrieNode current = root;
		
		for (int i = 0; i < prefix.length(); i++) {
			int index = prefix.charAt(i) - 'a';
			if (current.children[index] == null) {
				return 0;
			}
			current = current.children[index];
		}
		
		int[] sum = new int[1];
		
		dfs(current, sum);
		
		return sum[0];
	}
	
	private void dfs(Lcp_677_TrieNode child, int[] sum) {
		if (child == null) {
			return;
		}
		
		sum[0] += child.value;
		
		for (Lcp_677_TrieNode c : child.children) {
			dfs(c, sum);
		}
	}
	
}
