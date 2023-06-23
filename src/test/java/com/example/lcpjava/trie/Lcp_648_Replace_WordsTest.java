package com.example.lcpjava.trie;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_648_Replace_WordsTest {
	
	private Lcp_648_Replace_Words lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_648_Replace_Words();
	}
	
	@Test
	void test_case_1() {
		// Arrange
		List<String> dictionary = Arrays.asList(new String[] { "cat", "bat", "rat" });
		String sentence = "the cattle was rattled by the battery";
		
		// Act
		String actual = lcp.replaceWords(dictionary, sentence);
		
		// Assert
		Assertions.assertEquals("the cat was rat by the bat", actual);
	}
	
	@Test
	void test_case_2() {
		// Arrange
		List<String> dictionary = Arrays.asList(new String[] { "a", "b", "c" });
		String sentence = "aadsfasf absbs bbab cadsfafs";
		
		// Act
		String actual = lcp.replaceWords(dictionary, sentence);
		
		// Assert
		Assertions.assertEquals("a a b c", actual);
	}
	
}
