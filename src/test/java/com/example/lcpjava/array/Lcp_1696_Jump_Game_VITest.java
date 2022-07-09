package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_1696_Jump_Game_VITest {
	
	private Lcp_1696_Jump_Game_VI lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_1696_Jump_Game_VI();
	}
	
	@Test
	void test_case_1() {
		int expected = 7;
		int[] nums = { 1, -1, -2, 4, -7, 3 };
		int k = 2;
		int test = lcp.maxResult(nums, k);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = 17;
		int[] nums = { 10, -5, -2, 4, 0, 3 };
		int k = 3;
		int test = lcp.maxResult(nums, k);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		int expected = 0;
		int[] nums = { 1, -5, -20, 4, -1, 3, -6, -3 };
		int k = 2;
		int test = lcp.maxResult(nums, k);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
