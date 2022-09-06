package com.example.lcpjava.backtracking;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_967_Numbers_With_Same_Consecutive_DifferencesTest {
	
	private Lcp_967_Numbers_With_Same_Consecutive_Differences lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_967_Numbers_With_Same_Consecutive_Differences();
	}
	
	@Test
	void test_case_1() {
		int[] expected = { 181, 292, 707, 818, 929 };
		int n = 3;
		int k = 7;
		int[] test = lcp.numsSameConsecDiff(n, k);
		
		assertThat(test).containsExactlyInAnyOrder(expected);
	}
	
	@Test
	void test_case_2() {
		int[] expected = { 10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98 };
		int n = 2;
		int k = 1;
		int[] test = lcp.numsSameConsecDiff(n, k);
		
		assertThat(test).containsExactlyInAnyOrder(expected);
	}
	
	@Test
	void test_case_3() {
		int[] expected = { 11, 22, 33, 44, 55, 66, 77, 88, 99 };
		int n = 2;
		int k = 0;
		int[] test = lcp.numsSameConsecDiff(n, k);
		
		assertThat(test).containsExactlyInAnyOrder(expected);
	}
	
}
