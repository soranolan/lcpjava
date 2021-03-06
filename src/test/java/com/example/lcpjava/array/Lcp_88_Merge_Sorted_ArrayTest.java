package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_88_Merge_Sorted_ArrayTest {
	
	private Lcp_88_Merge_Sorted_Array lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_88_Merge_Sorted_Array();
	}
	
	@Test
	void test_case_1() {
		int[] expected = { 1, 2, 2, 3, 5, 6 };
		int[] test = { 1, 2, 3, 0, 0, 0 };
		int m = 3;
		int[] nums2 = { 2, 5, 6 };
		int n = 3;
		lcp.merge(test, m, nums2, n);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int[] expected = { 1 };
		int[] test = { 1 };
		int m = 1;
		int[] nums2 = {};
		int n = 0;
		lcp.merge(test, m, nums2, n);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		int[] expected = { 1 };
		int[] test = { 0 };
		int m = 0;
		int[] nums2 = { 1 };
		int n = 1;
		lcp.merge(test, m, nums2, n);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
