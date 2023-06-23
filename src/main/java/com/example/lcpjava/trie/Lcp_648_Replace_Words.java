package com.example.lcpjava.trie;

import java.util.List;

import com.example.lcpjava.common.Lcp_648_TrieNode;
import com.example.lcpjava.common.Lcp_648_TrieNode_1;

public class Lcp_648_Replace_Words {
	
	private Lcp_648_TrieNode_1 root_1;
	
	private Lcp_648_TrieNode root;
	
	public Lcp_648_Replace_Words() {
		root_1 = new Lcp_648_TrieNode_1();
		root = new Lcp_648_TrieNode();
	}
	
	/**
	 * n : roots length
	 * m : sentence length
	 * l : max word length in sentence
	 * 
	 * time  : O(n + m * l)
	 * space : O(n + m)
	 * */
	public String replaceWords_1(List<String> dictionary, String sentence) {
		for (String str : dictionary) {
			insert_1(str);																							// T : O(n); S : O(n)
		}
		
		String[] sentences = sentence.split(" ");																	// S : O(m)
		for (int i = 0; i < sentences.length; i++) {																// T : O(m)
			String word = sentences[i];
			int index = startWith_1(word);																			// T : O(l)
			if (index != -1) {
				sentences[i] = word.substring(0, index + 1);														// T : O(index)
			}
		}
		
		return String.join(" ", sentences);																			// T : O(m)
	}
	
	private void insert_1(String word) {
		Lcp_648_TrieNode_1 current = root_1;
		
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (current.children[index] == null) {
				current.children[index] = new Lcp_648_TrieNode_1();
			}
			current = current.children[index];
		}
		
		current.isEnd = true;
	}
	
	private int startWith_1(String word) {
		Lcp_648_TrieNode_1 current = root_1;
		
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (current.children[index] == null) {
				return -1;
			}
			if (current.children[index].isEnd) {
				return i;
			}
			current = current.children[index];
		}
		
		return -1;
	}
	
	/**
	 * n : roots length
	 * m : sentence length
	 * l : max word length in sentence
	 * 
	 * time  : O(n + m)
	 * space : O(n + m)
	 * 
	 * Accepted Solutions Runtime Distribution
	 * */
	public String replaceWords(List<String> dictionary, String sentence) {
		for (String str : dictionary) {
			insert(str);																							// T : O(n); S : O(n)
		}
		
		String[] sentences = sentence.split(" ");																	// S : O(m)
		for (int i = 0; i < sentences.length; i++) {																// T : O(m)
			String word = sentences[i];
			String replace = startWith(word);																		// T : O(l)
			if (replace != null) {
				sentences[i] = replace;
			}
		}
		
		return String.join(" ", sentences);																			// T : O(m)
	}
	
	private void insert(String word) {
		Lcp_648_TrieNode current = root;
		
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (current.children[index] == null) {
				current.children[index] = new Lcp_648_TrieNode();
			}
			current = current.children[index];
		}
		
		current.word = word;
	}
	
	private String startWith(String word) {
		Lcp_648_TrieNode current = root;
		
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (current.children[index] == null) {
				return null;
			}
			if (current.children[index].word != null) {
				return current.children[index].word;
			}
			current = current.children[index];
		}
		
		return null;
	}
	
}
