package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_2114_Maximum_Number_of_Words_Found_in_SentencesTest {
	
	private Lcp_2114_Maximum_Number_of_Words_Found_in_Sentences lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_2114_Maximum_Number_of_Words_Found_in_Sentences();
	}
	
	@Test
	void test_case_1() {
		int expected = 6;
		String[] sentences = { "alice and bob love leetcode", "i think so too", "this is great thanks very much" };
		int test = lcp.mostWordsFound(sentences);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = 3;
		String[] sentences = { "please wait", "continue to fight", "continue to win" };
		int test = lcp.mostWordsFound(sentences);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
