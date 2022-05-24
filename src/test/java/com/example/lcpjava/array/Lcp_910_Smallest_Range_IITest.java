package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_910_Smallest_Range_IITest {
	
	@Test
	void test_case_1() {
		Lcp_910_Smallest_Range_II lcp = new Lcp_910_Smallest_Range_II();
		
		int expected = 0;
		int[] nums = { 1 };
		int k = 0;
		int test = lcp.smallestRangeII(nums, k);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_910_Smallest_Range_II lcp = new Lcp_910_Smallest_Range_II();
		
		int expected = 6;
		int[] nums = { 0, 10 };
		int k = 2;
		int test = lcp.smallestRangeII(nums, k);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_910_Smallest_Range_II lcp = new Lcp_910_Smallest_Range_II();
		
		int expected = 3;
		int[] nums = { 1, 3, 6 };
		int k = 3;
		int test = lcp.smallestRangeII(nums, k);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
