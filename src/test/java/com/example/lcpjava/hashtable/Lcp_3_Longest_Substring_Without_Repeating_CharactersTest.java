package com.example.lcpjava.hashtable;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_3_Longest_Substring_Without_Repeating_CharactersTest {
	
	@Test
	void test_case_1() {
		Lcp_3_Longest_Substring_Without_Repeating_Characters lcp = new Lcp_3_Longest_Substring_Without_Repeating_Characters();
		
		int expected = 3;
		String input = "abcabcbb";
		int test = lcp.lengthOfLongestSubstring(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_3_Longest_Substring_Without_Repeating_Characters lcp = new Lcp_3_Longest_Substring_Without_Repeating_Characters();
		
		int expected = 1;
		String input = "bbbbb";
		int test = lcp.lengthOfLongestSubstring(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_3_Longest_Substring_Without_Repeating_Characters lcp = new Lcp_3_Longest_Substring_Without_Repeating_Characters();
		
		int expected = 3;
		String input = "pwwkew";
		int test = lcp.lengthOfLongestSubstring(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_4() {
		Lcp_3_Longest_Substring_Without_Repeating_Characters lcp = new Lcp_3_Longest_Substring_Without_Repeating_Characters();
		
		int expected = 0;
		String input = "";
		int test = lcp.lengthOfLongestSubstring(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_5() {
		Lcp_3_Longest_Substring_Without_Repeating_Characters lcp = new Lcp_3_Longest_Substring_Without_Repeating_Characters();
		
		int expected = 1;
		String input = " ";
		int test = lcp.lengthOfLongestSubstring(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
