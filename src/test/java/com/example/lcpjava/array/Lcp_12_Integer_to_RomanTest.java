package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_12_Integer_to_RomanTest {
	
	private Lcp_12_Integer_to_Roman lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_12_Integer_to_Roman();
	}
	
	@Test
	void test_case_1() {
		String expected = "III";
		int num = 3;
		String test = lcp.intToRoman(num);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		String expected = "LVIII";
		int num = 58;
		String test = lcp.intToRoman(num);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		String expected = "MCMXCIV";
		int num = 1994;
		String test = lcp.intToRoman(num);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
