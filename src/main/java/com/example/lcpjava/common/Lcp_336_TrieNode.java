package com.example.lcpjava.common;

import java.util.ArrayList;
import java.util.List;

public class Lcp_336_TrieNode {

	public Lcp_336_TrieNode[] children;
	public int wordIndex;
	public List<Integer> restOfTheWord;

	public Lcp_336_TrieNode() {
		children = new Lcp_336_TrieNode[26];
		wordIndex = -1;
		restOfTheWord = new ArrayList<>();
	}

}
