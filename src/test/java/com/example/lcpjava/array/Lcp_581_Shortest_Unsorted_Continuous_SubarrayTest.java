package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_581_Shortest_Unsorted_Continuous_SubarrayTest {
	
	@Test
	void test_case_1() {
		Lcp_581_Shortest_Unsorted_Continuous_Subarray lcp = new Lcp_581_Shortest_Unsorted_Continuous_Subarray();
		
		int expected = 5;
		int[] nums = { 2, 6, 4, 8, 10, 9, 15 };
		int test = lcp.findUnsortedSubarray(nums);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_581_Shortest_Unsorted_Continuous_Subarray lcp = new Lcp_581_Shortest_Unsorted_Continuous_Subarray();
		
		int expected = 0;
		int[] nums = { 1, 2, 3, 4 };
		int test = lcp.findUnsortedSubarray(nums);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_581_Shortest_Unsorted_Continuous_Subarray lcp = new Lcp_581_Shortest_Unsorted_Continuous_Subarray();
		
		int expected = 0;
		int[] nums = { 1 };
		int test = lcp.findUnsortedSubarray(nums);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_4() {
		Lcp_581_Shortest_Unsorted_Continuous_Subarray lcp = new Lcp_581_Shortest_Unsorted_Continuous_Subarray();
		
		int expected = 9;
		int[] nums = { 2, 3, 5, 1, 3, 4, 4, 4, 4, 6, 7, 8 };
		int test = lcp.findUnsortedSubarray(nums);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
