package com.example.lcpjava.stack;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_496_Next_Greater_Element_ITest {
	
	@Test
	void test_case_1() {
		Lcp_496_Next_Greater_Element_I lcp = new Lcp_496_Next_Greater_Element_I();
		
		int[] expected = { -1, 3, -1 };
		int[] nums1 = { 4, 1, 2 };
		int[] nums2 = { 1, 3, 4, 2 };
		int[] test = lcp.nextGreaterElement(nums1, nums2);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_496_Next_Greater_Element_I lcp = new Lcp_496_Next_Greater_Element_I();
		
		int[] expected = { 3, -1 };
		int[] nums1 = { 2, 4 };
		int[] nums2 = { 1, 2, 3, 4 };
		int[] test = lcp.nextGreaterElement(nums1, nums2);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_496_Next_Greater_Element_I lcp = new Lcp_496_Next_Greater_Element_I();
		
		int[] expected = { 7, 7, 7, 7, 7 };
		int[] nums1 = { 1, 3, 5, 2, 4 };
		int[] nums2 = { 6, 5, 4, 3, 2, 1, 7 };
		int[] test = lcp.nextGreaterElement(nums1, nums2);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
