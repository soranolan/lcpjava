package com.example.lcpjava.dynamicprogramming;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_97_Interleaving_StringTest {
	
	private Lcp_97_Interleaving_String lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_97_Interleaving_String();
	}
	
	@Test
	void test_case_1() {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		boolean test = lcp.isInterleave(s1, s2, s3);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_2() {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbbaccc";
		boolean test = lcp.isInterleave(s1, s2, s3);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_3() {
		String s1 = "";
		String s2 = "";
		String s3 = "";
		boolean test = lcp.isInterleave(s1, s2, s3);
		
		assertThat(test).isTrue();
	}
	
}
