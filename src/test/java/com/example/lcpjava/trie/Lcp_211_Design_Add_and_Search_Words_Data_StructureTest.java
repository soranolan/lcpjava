package com.example.lcpjava.trie;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_211_Design_Add_and_Search_Words_Data_StructureTest {
	
	private WordDictionary lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new WordDictionary();
	}
	
	@Test
	void test_case_1() {
		// Arrange
		boolean actual = false;
		lcp.addWord("bad");
		lcp.addWord("dad");
		lcp.addWord("mad");
		
		// Act
		actual = lcp.search("pad");
		
		// Assert
		assertFalse(actual);
		
		// Act
		actual = lcp.search("bad");
		
		// Assert
		assertTrue(actual);
		
		// Act
		actual = lcp.search(".ad");
		
		// Assert
		assertTrue(actual);
		
		// Act
		actual = lcp.search("b..");
		
		// Assert
		assertTrue(actual);
	}
	
	@Test
	void test_case_2() {
		// Arrange
		lcp.addWord("a");
		
		// Act
		boolean actual = lcp.search(".");
		
		// Assert
		assertTrue(actual);
	}
	
}
