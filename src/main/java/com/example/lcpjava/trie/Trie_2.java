package com.example.lcpjava.trie;

import com.example.lcpjava.common.TrieNodeArray;

public class Trie_2 {
	
	TrieNodeArray root;
	
	public Trie_2() {
		root = new TrieNodeArray();
	}
	
	public void insert(String word) {
		TrieNodeArray current = root;
		for (Character c : word.toCharArray()) {
			int index = c - 'a';
			if (current.children[index] == null) {
				current.children[index] = new TrieNodeArray();
			}
			current = current.children[index];
		}
		current.isWord = true;
	}
	
	public boolean search(String word) {
		TrieNodeArray current = root;
		for (Character c : word.toCharArray()) {
			int index = c - 'a';
			if (current.children[index] == null) {
				return false;
			}
			current = current.children[index];
		}
		return current.isWord;
	}
	
	public boolean startsWith(String prefix) {
		TrieNodeArray current = root;
		for (Character c : prefix.toCharArray()) {
			int index = c - 'a';
			if (current.children[index] == null) {
				return false;
			}
			current = current.children[index];
		}
		return true;
	}
	
}
