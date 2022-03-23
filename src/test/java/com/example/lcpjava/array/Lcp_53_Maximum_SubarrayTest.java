package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_53_Maximum_SubarrayTest {
	
	@Test
	void test_case_1() {
		Lcp_53_Maximum_Subarray lcp = new Lcp_53_Maximum_Subarray();
		
		int expected = 6;
		int[] input = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int test = lcp.maxSubArray(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_53_Maximum_Subarray lcp = new Lcp_53_Maximum_Subarray();
		
		int expected = 1;
		int[] input = { 1 };
		int test = lcp.maxSubArray(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_53_Maximum_Subarray lcp = new Lcp_53_Maximum_Subarray();
		
		int expected = 23;
		int[] input = { 5, 4, -1, 7, 8 };
		int test = lcp.maxSubArray(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_4() {
		Lcp_53_Maximum_Subarray lcp = new Lcp_53_Maximum_Subarray();
		
		int expected = -1;
		int[] input = { -1 };
		int test = lcp.maxSubArray(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
