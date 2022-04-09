package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_43_Multiply_StringsTest {
	
	@Test
	void test_case_1() {
		Lcp_43_Multiply_Strings lcp = new Lcp_43_Multiply_Strings();
		
		String expected = "6";
		String num1 = "2";
		String num2 = "3";
		String test = lcp.multiply(num1, num2);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_43_Multiply_Strings lcp = new Lcp_43_Multiply_Strings();
		
		String expected = "56088";
		String num1 = "123";
		String num2 = "456";
		String test = lcp.multiply(num1, num2);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_43_Multiply_Strings lcp = new Lcp_43_Multiply_Strings();
		
		String expected = "891";
		String num1 = "9";
		String num2 = "99";
		String test = lcp.multiply(num1, num2);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
