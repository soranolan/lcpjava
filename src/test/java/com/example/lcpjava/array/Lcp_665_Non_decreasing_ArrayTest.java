package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_665_Non_decreasing_ArrayTest {
	
	private Lcp_665_Non_decreasing_Array lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_665_Non_decreasing_Array();
	}
	
	@Test
	void test_case_1() {
		int[] nums = { 4, 2, 3 };
		boolean test = lcp.checkPossibility(nums);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_2() {
		int[] nums = { 4, 2, 1 };
		boolean test = lcp.checkPossibility(nums);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_23() {
		int[] nums = { 3, 4, 2, 3 };
		boolean test = lcp.checkPossibility(nums);
		
		assertThat(test).isFalse();
	}
	
}
