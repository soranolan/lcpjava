package com.example.lcpjava.hashtable;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_13_Roman_to_IntegerTest {
	
	@Test
	void test_case_1() {
		Lcp_13_Roman_to_Integer lcp = new Lcp_13_Roman_to_Integer();
		
		int expected = 3;
		String input = "III";
		int test = lcp.romanToInt(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_13_Roman_to_Integer lcp = new Lcp_13_Roman_to_Integer();
		
		int expected = 58;
		String input = "LVIII";
		int test = lcp.romanToInt(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_13_Roman_to_Integer lcp = new Lcp_13_Roman_to_Integer();
		
		int expected = 1994;
		String input = "MCMXCIV";
		int test = lcp.romanToInt(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
