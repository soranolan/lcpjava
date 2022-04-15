package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_2185_Counting_Words_With_a_Given_PrefixTest {
	
	@Test
	void test_case_1() {
		Lcp_2185_Counting_Words_With_a_Given_Prefix lcp = new Lcp_2185_Counting_Words_With_a_Given_Prefix();
		
		int expected = 2;
		String[] words = { "pay", "attention", "practice", "attend" };
		String pref = "at";
		int test = lcp.prefixCount(words, pref);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_2185_Counting_Words_With_a_Given_Prefix lcp = new Lcp_2185_Counting_Words_With_a_Given_Prefix();
		
		int expected = 0;
		String[] words = { "leetcode", "win", "loops", "success" };
		String pref = "code";
		int test = lcp.prefixCount(words, pref);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
