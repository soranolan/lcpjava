package com.example.lcpjava.common;

public class TrieNodeArray {
	
	public boolean isWord;
	
	public TrieNodeArray[] children;
	
	public TrieNodeArray() {
		isWord = false;
		children = new TrieNodeArray[26];
	}
	
}
