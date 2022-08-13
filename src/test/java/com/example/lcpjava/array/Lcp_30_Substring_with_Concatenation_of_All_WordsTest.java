package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_30_Substring_with_Concatenation_of_All_WordsTest {
	
	private Lcp_30_Substring_with_Concatenation_of_All_Words lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_30_Substring_with_Concatenation_of_All_Words();
	}
	
	@Test
	void test_case_1() {
		List<Integer> expected = Arrays.asList(new Integer[] { 0, 9 });
		String s = "barfoothefoobarman";
		String[] words = { "foo", "bar" };
		List<Integer> test = lcp.findSubstring(s, words);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		List<Integer> expected = Arrays.asList(new Integer[] {});
		String s = "wordgoodgoodgoodbestword";
		String[] words = { "word", "good", "best", "word" };
		List<Integer> test = lcp.findSubstring(s, words);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		List<Integer> expected = Arrays.asList(new Integer[] { 6, 9, 12 });
		String s = "barfoofoobarthefoobarman";
		String[] words = { "bar", "foo", "the" };
		List<Integer> test = lcp.findSubstring(s, words);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
