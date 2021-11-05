package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_14_Longest_Common_PrefixTest {
	
	@Test
	void test_case_1() {
		Lcp_14_Longest_Common_Prefix lcp = new Lcp_14_Longest_Common_Prefix();
		
		String expected = "fl";
		String[] input = { "flower", "flow", "flight" };
		String test = lcp.longestCommonPrefix(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_14_Longest_Common_Prefix lcp = new Lcp_14_Longest_Common_Prefix();
		
		String expected = "";
		String[] input = { "dog", "racecar", "car" };
		String test = lcp.longestCommonPrefix(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_14_Longest_Common_Prefix lcp = new Lcp_14_Longest_Common_Prefix();
		
		String expected = "";
		String[] input = { "c", "acc", "ccc" };
		String test = lcp.longestCommonPrefix(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
