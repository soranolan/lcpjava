package com.example.lcpjava.hashtable;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_1_Two_SumTest {
	
	@Test
	void test_case_1() {
		Lcp_1_Two_Sum lcp = new Lcp_1_Two_Sum();
		
		int[] expected = { 0, 1 };
		int[] input = { 2, 7, 11, 15 };
		int target = 9;
		int[] test = lcp.twoSum(input, target);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_1_Two_Sum lcp = new Lcp_1_Two_Sum();
		
		int[] expected = { 1, 2 };
		int[] input = { 3, 2, 4 };
		int target = 6;
		int[] test = lcp.twoSum(input, target);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_1_Two_Sum lcp = new Lcp_1_Two_Sum();
		
		int[] expected = { 0, 1 };
		int[] input = { 3, 3 };
		int target = 6;
		int[] test = lcp.twoSum(input, target);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
