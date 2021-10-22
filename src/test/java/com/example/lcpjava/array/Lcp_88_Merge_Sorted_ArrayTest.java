package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_88_Merge_Sorted_ArrayTest {
	
	@Test
	void test_case_1() {
		Lcp_88_Merge_Sorted_Array lcp = new Lcp_88_Merge_Sorted_Array();
		
		int[] expect = { 1, 2, 2, 3, 5, 6 };
		int[] test = { 1, 2, 3, 0, 0, 0 };
		int m = 3;
		int[] nums2 = { 2, 5, 6 };
		int n = 3;
		lcp.merge(test, m, nums2, n);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_2() {
		Lcp_88_Merge_Sorted_Array lcp = new Lcp_88_Merge_Sorted_Array();
		
		int[] expect = { 1 };
		int[] test = { 1 };
		int m = 1;
		int[] nums2 = {  };
		int n = 0;
		lcp.merge(test, m, nums2, n);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_3() {
		Lcp_88_Merge_Sorted_Array lcp = new Lcp_88_Merge_Sorted_Array();
		
		int[] expect = { 1 };
		int[] test = { 0 };
		int m = 0;
		int[] nums2 = { 1 };
		int n = 1;
		lcp.merge(test, m, nums2, n);
		
		assertThat(test).isEqualTo(expect);
	}
	
}
