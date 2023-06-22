package com.example.lcpjava.trie;

import java.util.HashMap;
import java.util.Map;

import com.example.lcpjava.common.Lcp_677_TrieNode;

// https://leetcode.com/problems/map-sum-pairs/solutions/1371761/c-java-python-trie-hashmap-efficient-clean-concise/
public class MapSum_2 {
	
	private Lcp_677_TrieNode root;
	
	private Map<String, Integer> memo = new HashMap<>();															// S : O(m)
	
	public MapSum_2() {
		root = new Lcp_677_TrieNode();
	}
	
	/**
	 * n : key length
	 * 
	 * time  : O(n)
	 * space : O(n + m)
	 * */
	public void insert(String key, int val) {
		int diff = val - memo.getOrDefault(key, 0);
		Lcp_677_TrieNode current = root;
		
		for (int i = 0; i < key.length(); i++) {
			int index = key.charAt(i) - 'a';
			if (current.children[index] == null) {
				current.children[index] = new Lcp_677_TrieNode();
			}
			current = current.children[index];
			current.value += diff;
		}
		
		memo.put(key, val);
	}
	
	/**
	 * n : prefix length
	 * 
	 * time  : O(n)
	 * space : O(1)
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
		
		return current.value;
	}
	
}
