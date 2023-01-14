package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_1061_Lexicographically_Smallest_Equivalent_StringTest {
	
	private Lcp_1061_Lexicographically_Smallest_Equivalent_String lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_1061_Lexicographically_Smallest_Equivalent_String();
	}
	
	@Test
	void test_case_1() {
		String expected = "makkek";
		String s1 = "parker";
		String s2 = "morris";
		String baseStr = "parser";
		String test = lcp.smallestEquivalentString(s1, s2, baseStr);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		String expected = "hdld";
		String s1 = "hello";
		String s2 = "world";
		String baseStr = "hold";
		String test = lcp.smallestEquivalentString(s1, s2, baseStr);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		String expected = "aauaaaaada";
		String s1 = "leetcode";
		String s2 = "programs";
		String baseStr = "sourcecode";
		String test = lcp.smallestEquivalentString(s1, s2, baseStr);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
