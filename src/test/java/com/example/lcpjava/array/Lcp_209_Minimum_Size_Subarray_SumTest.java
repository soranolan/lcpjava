package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_209_Minimum_Size_Subarray_SumTest {
	
	@Test
	void test_case_1() {
		Lcp_209_Minimum_Size_Subarray_Sum lcp = new Lcp_209_Minimum_Size_Subarray_Sum();
		
		int expected = 2;
		int target = 7;
		int[] input = { 2, 3, 1, 2, 4, 3 };
		int test = lcp.minSubArrayLen(target, input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_209_Minimum_Size_Subarray_Sum lcp = new Lcp_209_Minimum_Size_Subarray_Sum();
		
		int expected = 1;
		int target = 4;
		int[] input = { 1, 4, 4 };
		int test = lcp.minSubArrayLen(target, input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_209_Minimum_Size_Subarray_Sum lcp = new Lcp_209_Minimum_Size_Subarray_Sum();
		
		int expected = 0;
		int target = 11;
		int[] input = { 1, 1, 1, 1, 1, 1, 1, 1 };
		int test = lcp.minSubArrayLen(target, input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_4() {
		Lcp_209_Minimum_Size_Subarray_Sum lcp = new Lcp_209_Minimum_Size_Subarray_Sum();
		
		int expected = 8;
		int target = 213;
		int[] input = { 12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12 };
		int test = lcp.minSubArrayLen(target, input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
