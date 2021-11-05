package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_283_Move_ZeroesTest {
	
	@Test
	void test_case_1() {
		Lcp_283_Move_Zeroes lcp = new Lcp_283_Move_Zeroes();
		
		int[] expected = { 1, 3, 12, 0, 0 };
		int[] test = { 0, 1, 0, 3, 12 };
		lcp.moveZeroes(test);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_283_Move_Zeroes lcp = new Lcp_283_Move_Zeroes();
		
		int[] expected = { 1, 3, 12, 0, 0 };
		int[] test = { 0, 0, 1, 3, 12 };
		lcp.moveZeroes(test);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_283_Move_Zeroes lcp = new Lcp_283_Move_Zeroes();
		
		int[] expected = { 0 };
		int[] test = { 0 };
		lcp.moveZeroes(test);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
