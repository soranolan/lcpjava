package com.example.lcpjava.trie;

import com.example.lcpjava.common.TrieNodeMap;

public class Trie_1 {
	
	TrieNodeMap root;
	
	public Trie_1() {
		root = new TrieNodeMap();
	}
	
	public void insert(String word) {
		TrieNodeMap current = root;
		for (Character c : word.toCharArray()) {
			if (!current.children.containsKey(c)) {
				current.children.put(c, new TrieNodeMap());
			}
			current = current.children.get(c);
		}
		current.isWord = true;
	}
	
	public boolean search(String word) {
		TrieNodeMap current = root;
		for (Character c : word.toCharArray()) {
			if (!current.children.containsKey(c)) {
				return false;
			}
			current = current.children.get(c);
		}
		return current.isWord;
	}
	
	public boolean startsWith(String prefix) {
		TrieNodeMap current = root;
		for (Character c : prefix.toCharArray()) {
			if (!current.children.containsKey(c)) {
				return false;
			}
			current = current.children.get(c);
		}
		return true;
	}
	
}
