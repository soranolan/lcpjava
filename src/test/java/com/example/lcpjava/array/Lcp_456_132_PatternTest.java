package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_456_132_PatternTest {
	
	@Test
	void test_case_1() {
		Lcp_456_132_Pattern lcp = new Lcp_456_132_Pattern();
		
		int[] nums = { 1, 2, 3, 4 };
		boolean test = lcp.find132pattern(nums);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_2() {
		Lcp_456_132_Pattern lcp = new Lcp_456_132_Pattern();
		
		int[] nums = { 3, 1, 4, 2 };
		boolean test = lcp.find132pattern(nums);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_3() {
		Lcp_456_132_Pattern lcp = new Lcp_456_132_Pattern();
		
		int[] nums = { -1, 3, 2, 0 };
		boolean test = lcp.find132pattern(nums);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_4() {
		Lcp_456_132_Pattern lcp = new Lcp_456_132_Pattern();
		
		int[] nums = { 1, 0, 1, -4, -3 };
		boolean test = lcp.find132pattern(nums);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_5() {
		Lcp_456_132_Pattern lcp = new Lcp_456_132_Pattern();
		
		int[] nums = { 9, 11, 8, 9, 10, 7, 9 };
		boolean test = lcp.find132pattern(nums);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_6() {
		Lcp_456_132_Pattern lcp = new Lcp_456_132_Pattern();
		
		int[] nums = { 2, 4, 3, 1 };
		boolean test = lcp.find132pattern(nums);
		
		assertThat(test).isTrue();
	}
	
}
