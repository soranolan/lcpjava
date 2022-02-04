package com.example.lcpjava.stack;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_1544_Make_The_String_GreatTest {
	
	@Test
	void test_case_1() {
		Lcp_1544_Make_The_String_Great lcp = new Lcp_1544_Make_The_String_Great();
		
		String expected = "leetcode";
		String input = "leEeetcode";
		String test = lcp.makeGood(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_1544_Make_The_String_Great lcp = new Lcp_1544_Make_The_String_Great();
		
		String expected = "";
		String input = "abBAcC";
		String test = lcp.makeGood(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_1544_Make_The_String_Great lcp = new Lcp_1544_Make_The_String_Great();
		
		String expected = "s";
		String input = "s";
		String test = lcp.makeGood(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
