package com.example.lcpjava.stack;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_494_Target_SumTest {
	
	@Test
	void test_case_1() {
		Lcp_494_Target_Sum lcp = new Lcp_494_Target_Sum();
		
		int expected = 5;
		
		int[] nums = { 1, 1, 1, 1, 1 };
		int target = 3;
		int test = lcp.findTargetSumWays(nums, target);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_494_Target_Sum lcp = new Lcp_494_Target_Sum();
		
		int expected = 1;
		
		int[] nums = { 1 };
		int target = 1;
		int test = lcp.findTargetSumWays(nums, target);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_494_Target_Sum lcp = new Lcp_494_Target_Sum();
		
		int expected = 0;
		
		int[] nums = { 100 };
		int target = -200;
		int test = lcp.findTargetSumWays(nums, target);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
