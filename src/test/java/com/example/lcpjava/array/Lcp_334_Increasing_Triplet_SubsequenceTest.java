package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_334_Increasing_Triplet_SubsequenceTest {
	
	private Lcp_334_Increasing_Triplet_Subsequence lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_334_Increasing_Triplet_Subsequence();
	}
	
	@Test
	void test_case_1() {
		int[] nums = { 1, 2, 3, 4, 5 };
		boolean test = lcp.increasingTriplet(nums);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_2() {
		int[] nums = { 5, 4, 3, 2, 1 };
		boolean test = lcp.increasingTriplet(nums);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_3() {
		int[] nums = { 2, 1, 5, 0, 4, 6 };
		boolean test = lcp.increasingTriplet(nums);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_4() {
		int[] nums = { 1, 1, 1, 1, 1, 1 };
		boolean test = lcp.increasingTriplet(nums);
		
		assertThat(test).isFalse();
	}
	
}
