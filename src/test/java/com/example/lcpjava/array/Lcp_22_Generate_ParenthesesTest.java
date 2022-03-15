package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

class Lcp_22_Generate_ParenthesesTest {
	
	@Test
	void test_case_1() {
		Lcp_22_Generate_Parentheses lcp = new Lcp_22_Generate_Parentheses();
		
		String[] expected = new String[] { "((()))", "(()())", "(())()", "()(())", "()()()" };
		int input = 3;
		List<String> test = lcp.generateParenthesis(input);
		
		assertThat(test).isEqualTo(Arrays.asList(expected));
	}
	
	@Test
	void test_case_2() {
		Lcp_22_Generate_Parentheses lcp = new Lcp_22_Generate_Parentheses();
		
		String[] expected = new String[] { "()" };
		int input = 1;
		List<String> test = lcp.generateParenthesis(input);
		
		assertThat(test).isEqualTo(Arrays.asList(expected));
	}
	
}
