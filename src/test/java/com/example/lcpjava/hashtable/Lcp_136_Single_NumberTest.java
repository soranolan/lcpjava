package com.example.lcpjava.hashtable;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_136_Single_NumberTest {
	
	@Test
	void test_case_1() {
		Lcp_136_Single_Number lcp = new Lcp_136_Single_Number();
		
		int expected = 1;
		int[] input = { 2, 2, 1 };
		int test = lcp.singleNumber(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_136_Single_Number lcp = new Lcp_136_Single_Number();
		
		int expected = 4;
		int[] input = { 4, 1, 2, 1, 2 };
		int test = lcp.singleNumber(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_136_Single_Number lcp = new Lcp_136_Single_Number();
		
		int expected = 1;
		int[] input = { 1 };
		int test = lcp.singleNumber(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
