package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_392_Is_SubsequenceTest {
	
	@Test
	void test_case_1() {
		Lcp_392_Is_Subsequence lcp = new Lcp_392_Is_Subsequence();
		
		String s = "abc";
		String t = "ahbgdc";
		boolean test = lcp.isSubsequence(s, t);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_2() {
		Lcp_392_Is_Subsequence lcp = new Lcp_392_Is_Subsequence();
		
		String s = "axc";
		String t = "ahbgdc";
		boolean test = lcp.isSubsequence(s, t);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_3() {
		Lcp_392_Is_Subsequence lcp = new Lcp_392_Is_Subsequence();
		
		String s = "";
		String t = "";
		boolean test = lcp.isSubsequence(s, t);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_4() {
		Lcp_392_Is_Subsequence lcp = new Lcp_392_Is_Subsequence();
		
		String s = "";
		String t = "abc";
		boolean test = lcp.isSubsequence(s, t);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_5() {
		Lcp_392_Is_Subsequence lcp = new Lcp_392_Is_Subsequence();
		
		String s = "abc";
		String t = "";
		boolean test = lcp.isSubsequence(s, t);
		
		assertThat(test).isFalse();
	}
	
}
