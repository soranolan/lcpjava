package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Lcp_5_Longest_Palindromic_SubstringTest {
	
	private Lcp_5_Longest_Palindromic_Substring lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_5_Longest_Palindromic_Substring();
	}
	
	@Test
	void test_case_1() {
		List<String> expected = Arrays.asList("bab", "aba");
		String s = "babad";
		String test = lcp.longestPalindrome(s);
		
		assertThat(test).isIn(expected);
	}
	
	@Test
	void test_case_2() {
		String expected = "bb";
		String s = "cbbd";
		String test = lcp.longestPalindrome(s);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
