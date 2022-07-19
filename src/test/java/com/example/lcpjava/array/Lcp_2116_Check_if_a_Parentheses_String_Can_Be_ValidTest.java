package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_2116_Check_if_a_Parentheses_String_Can_Be_ValidTest {
	
	private Lcp_2116_Check_if_a_Parentheses_String_Can_Be_Valid lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_2116_Check_if_a_Parentheses_String_Can_Be_Valid();
	}
	
	@Test
	void test_case_1() {
		String s = "))()))";
		String locked = "010100";
		boolean test = lcp.canBeValid(s, locked);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_2() {
		String s = "()()";
		String locked = "0000";
		boolean test = lcp.canBeValid(s, locked);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_3() {
		String s = ")";
		String locked = "0";
		boolean test = lcp.canBeValid(s, locked);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_4() {
		String s = "())(()(()(())()())(())((())(()())((())))))(((((((())(()))))(";
		String locked = "100011110110011011010111100111011101111110000101001101001111";
		boolean test = lcp.canBeValid(s, locked);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_5() {
		String s = "(((((()((()))()())))()()((()()(()())())(((()())()))()())(()(()))((()()()(())((()((())()()((((()()))))))()((()()((()(())))))))(())))(()))))()(()())))()())()))(()(((()))())())()((()()))()())))()))())((()()(())())(()))))())())()()(())(()())())))(((((()(()))))))()))()))(())(())))()())(((";
		String locked = "01010111111001100101110101010000000011100000000001111110111011001100000011101100101011101011100000000001100001001111001010011110110011100111000101111101100000011111000101001110110000111011110110011101001110101001000111100111101011100101010100110110100100101001011110010010001000001101";
		boolean test = lcp.canBeValid(s, locked);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_6() {
		String s = "())()))()(()(((())(()()))))((((()())(())";
		String locked = "1011101100010001001011000000110010100101";
		boolean test = lcp.canBeValid(s, locked);
		
		assertThat(test).isTrue();
	}
	
}
