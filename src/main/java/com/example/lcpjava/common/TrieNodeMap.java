package com.example.lcpjava.common;

import java.util.HashMap;
import java.util.Map;

public class TrieNodeMap {
	
	public boolean isWord;
	
	public Map<Character, TrieNodeMap> children;
	
	public TrieNodeMap() {
		isWord = false;
		children = new HashMap<>();
	}
	
}
