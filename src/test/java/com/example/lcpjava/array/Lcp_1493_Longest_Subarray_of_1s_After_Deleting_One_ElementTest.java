package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_1493_Longest_Subarray_of_1s_After_Deleting_One_ElementTest {
	
	@Test
	void test_case_1() {
		Lcp_1493_Longest_Subarray_of_1s_After_Deleting_One_Element lcp = new Lcp_1493_Longest_Subarray_of_1s_After_Deleting_One_Element();
		
		int expected = 3;
		int[] nums = { 1, 1, 0, 1 };
		int test = lcp.longestSubarray(nums);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_1493_Longest_Subarray_of_1s_After_Deleting_One_Element lcp = new Lcp_1493_Longest_Subarray_of_1s_After_Deleting_One_Element();
		
		int expected = 5;
		int[] nums = { 0, 1, 1, 1, 0, 1, 1, 0, 1 };
		int test = lcp.longestSubarray(nums);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_1493_Longest_Subarray_of_1s_After_Deleting_One_Element lcp = new Lcp_1493_Longest_Subarray_of_1s_After_Deleting_One_Element();
		
		int expected = 2;
		int[] nums = { 1, 1, 1 };
		int test = lcp.longestSubarray(nums);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
