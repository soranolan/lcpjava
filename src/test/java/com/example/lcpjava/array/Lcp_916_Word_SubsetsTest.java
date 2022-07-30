package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_916_Word_SubsetsTest {
	
	private Lcp_916_Word_Subsets lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_916_Word_Subsets();
	}
	
	@Test
	void test_case_1() {
		List<String> expected = Arrays.asList(new String[] { "facebook", "google", "leetcode" });
		String[] words1 = { "amazon", "apple", "facebook", "google", "leetcode" };
		String[] words2 = { "e", "o" };
		List<String> test = lcp.wordSubsets(words1, words2);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		List<String> expected = Arrays.asList(new String[] { "apple", "google", "leetcode" });
		String[] words1 = { "amazon", "apple", "facebook", "google", "leetcode" };
		String[] words2 = { "l", "e" };
		List<String> test = lcp.wordSubsets(words1, words2);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		List<String> expected = Arrays.asList(new String[] { "google", "leetcode" });
		String[] words1 = { "amazon", "apple", "facebook", "google", "leetcode" };
		String[] words2 = { "lo", "eo" };
		List<String> test = lcp.wordSubsets(words1, words2);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
