package com.example.lcpjava.dynamicprogramming;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_338_Counting_BitsTest {
	
	@Test
	void test_case_1() {
		Lcp_338_Counting_Bits lcp = new Lcp_338_Counting_Bits();
		
		int[] expected = { 0, 1, 1 };
		int input = 2;
		int[] test = lcp.countBits(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_338_Counting_Bits lcp = new Lcp_338_Counting_Bits();
		
		int[] expected = { 0, 1, 1, 2, 1, 2 };
		int input = 5;
		int[] test = lcp.countBits(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
