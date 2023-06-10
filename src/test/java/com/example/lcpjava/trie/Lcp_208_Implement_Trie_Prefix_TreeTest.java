package com.example.lcpjava.trie;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_208_Implement_Trie_Prefix_TreeTest {
	
	private Trie trie;
	
	@BeforeEach
	void beforeEach() {
		trie = new Trie();
	}
	
	@Test
	void test_case_1() {
		boolean actual = false;
		
		trie.insert("apple");
		
		actual = trie.search("apple");
		assertTrue(actual);
		
		actual = trie.search("app");
		assertFalse(actual);
		
		actual = trie.startsWith("app");
		assertTrue(actual);
		
		trie.insert("app");
		
		actual = trie.search("app");
		assertTrue(actual);
	}
	
}
