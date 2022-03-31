package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_64_Minimum_Path_SumTest {
	
	@Test
	void test_case_1() {
		Lcp_64_Minimum_Path_Sum lcp = new Lcp_64_Minimum_Path_Sum();
		
		int expected = 7;
		int[][] input = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		int test = lcp.minPathSum(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_64_Minimum_Path_Sum lcp = new Lcp_64_Minimum_Path_Sum();
		
		int expected = 12;
		int[][] input = { { 1, 2, 3 }, { 4, 5, 6 } };
		int test = lcp.minPathSum(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
