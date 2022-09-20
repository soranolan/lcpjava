package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_718_Maximum_Length_of_Repeated_SubarrayTest {
	
	private Lcp_718_Maximum_Length_of_Repeated_Subarray lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_718_Maximum_Length_of_Repeated_Subarray();
	}
	
	@Test
	void test_case_1() {
		int expected = 3;
		int[] nums1 = { 1, 2, 3, 2, 1 };
		int[] nums2 = { 3, 2, 1, 4, 7 };
		int test = lcp.findLength(nums1, nums2);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = 5;
		int[] nums1 = { 0, 0, 0, 0, 0 };
		int[] nums2 = { 0, 0, 0, 0, 0 };
		int test = lcp.findLength(nums1, nums2);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
