package com.example.lcpjava.hashtable;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_349_Intersection_of_Two_ArraysTest {
	
	@Test
	void test_case_1() {
		Lcp_349_Intersection_of_Two_Arrays lcp = new Lcp_349_Intersection_of_Two_Arrays();
		
		int[] expected = { 2 };
		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };
		int[] test = lcp.intersection(nums1, nums2);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_349_Intersection_of_Two_Arrays lcp = new Lcp_349_Intersection_of_Two_Arrays();
		
		int[] expected = { 4, 9 };
		int[] nums1 = { 4, 9, 5 };
		int[] nums2 = { 9, 4, 9, 8, 4 };
		int[] test = lcp.intersection(nums1, nums2);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_349_Intersection_of_Two_Arrays lcp = new Lcp_349_Intersection_of_Two_Arrays();
		
		int[] expected = { 1 };
		int[] nums1 = { 2, 1 };
		int[] nums2 = { 1, 1 };
		int[] test = lcp.intersection(nums1, nums2);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
