package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_647_Palindromic_SubstringsTest {
	
	@Test
	void test_case_1() {
		Lcp_647_Palindromic_Substrings lcp = new Lcp_647_Palindromic_Substrings();
		
		int expected = 3;
		String input = "abc";
		int test = lcp.countSubstrings(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_647_Palindromic_Substrings lcp = new Lcp_647_Palindromic_Substrings();
		
		int expected = 6;
		String input = "aaa";
		int test = lcp.countSubstrings(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
