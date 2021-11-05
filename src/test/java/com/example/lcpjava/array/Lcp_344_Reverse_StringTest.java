package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_344_Reverse_StringTest {
	
	@Test
	void test_case_1() {
		Lcp_344_Reverse_String lcp = new Lcp_344_Reverse_String();
		
		char[] expected = { 'o', 'l', 'l', 'e', 'h' };
		char[] test = { 'h', 'e', 'l', 'l', 'o' };
		lcp.reverseString(test);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_344_Reverse_String lcp = new Lcp_344_Reverse_String();
		
		char[] expected = { 'h', 'a', 'n', 'n', 'a', 'H' };
		char[] test = { 'H', 'a', 'n', 'n', 'a', 'h' };
		lcp.reverseString(test);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
