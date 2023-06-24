package com.example.lcpjava.common;

public class Lcp_211_TrieNode {
	
	public boolean isEnd;
	
	public Lcp_211_TrieNode[] children;
	
	public Lcp_211_TrieNode() {
		isEnd = false;
		children = new Lcp_211_TrieNode[26];
	}
	
}
