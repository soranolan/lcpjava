package com.example.lcpjava.stack;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_150_Evaluate_Reverse_Polish_NotationTest {
	
	@Test
	void test_case_1() {
		Lcp_150_Evaluate_Reverse_Polish_Notation lcp = new Lcp_150_Evaluate_Reverse_Polish_Notation();
		
		int expected = 9;
		
		String[] input = { "2", "1", "+", "3", "*" };
		int test = lcp.evalRPN(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_150_Evaluate_Reverse_Polish_Notation lcp = new Lcp_150_Evaluate_Reverse_Polish_Notation();
		
		int expected = 6;
		
		String[] input = { "4", "13", "5", "/", "+" };
		int test = lcp.evalRPN(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_150_Evaluate_Reverse_Polish_Notation lcp = new Lcp_150_Evaluate_Reverse_Polish_Notation();
		
		int expected = 22;
		
		String[] input = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
		int test = lcp.evalRPN(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
