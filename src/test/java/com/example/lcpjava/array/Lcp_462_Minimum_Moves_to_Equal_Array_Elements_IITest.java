package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_462_Minimum_Moves_to_Equal_Array_Elements_IITest {
	
	private Lcp_462_Minimum_Moves_to_Equal_Array_Elements_II lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_462_Minimum_Moves_to_Equal_Array_Elements_II();
	}
	
	@Test
	void test_case_1() {
		int expected = 2;
		int[] nums = { 1, 2, 3 };
		int test = lcp.minMoves2(nums);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = 16;
		int[] nums = { 1, 10, 2, 9 };
		int test = lcp.minMoves2(nums);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		int expected = 14;
		int[] nums = { 1, 0, 0, 8, 6 };
		int test = lcp.minMoves2(nums);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
