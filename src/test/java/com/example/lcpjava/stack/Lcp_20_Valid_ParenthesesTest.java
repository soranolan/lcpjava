package com.example.lcpjava.stack;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_20_Valid_ParenthesesTest {
	
	@Test
	void test_case_1() {
		Lcp_20_Valid_Parentheses lcp = new Lcp_20_Valid_Parentheses();
		
		boolean expected = true;
		
		String input = "()";
		boolean test = lcp.isValid(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_20_Valid_Parentheses lcp = new Lcp_20_Valid_Parentheses();
		
		boolean expected = true;
		
		String input = "()[]{}";
		boolean test = lcp.isValid(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_20_Valid_Parentheses lcp = new Lcp_20_Valid_Parentheses();
		
		boolean expected = false;
		
		String input = "(]";
		boolean test = lcp.isValid(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_4() {
		Lcp_20_Valid_Parentheses lcp = new Lcp_20_Valid_Parentheses();
		
		boolean expected = false;
		
		String input = "([)]";
		boolean test = lcp.isValid(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_5() {
		Lcp_20_Valid_Parentheses lcp = new Lcp_20_Valid_Parentheses();
		
		boolean expected = true;
		
		String input = "{[]}";
		boolean test = lcp.isValid(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
