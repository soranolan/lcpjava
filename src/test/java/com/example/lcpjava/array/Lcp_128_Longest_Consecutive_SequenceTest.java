package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_128_Longest_Consecutive_SequenceTest {
	
	private Lcp_128_Longest_Consecutive_Sequence lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_128_Longest_Consecutive_Sequence();
	}
	
	@Test
	void test_case_1() {
		int expected = 4;
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		int test = lcp.longestConsecutive(nums);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = 9;
		int[] nums = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
		int test = lcp.longestConsecutive(nums);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		int expected = 3;
		int[] nums = { 1, 2, 0, 1 };
		int test = lcp.longestConsecutive(nums);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_4() {
		int expected = 0;
		int[] nums = {  };
		int test = lcp.longestConsecutive(nums);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_5() {
		int expected = 2;
		int[] nums = { 0, -1 };
		int test = lcp.longestConsecutive(nums);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
