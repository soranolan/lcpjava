package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_498_Diagonal_TraverseTest {
	
	@Test
	void test_case_1() {
		Lcp_498_Diagonal_Traverse lcp = new Lcp_498_Diagonal_Traverse();
		
		int[] expect = { 1, 2, 4, 7, 5, 3, 6, 8, 9 };
		int[][] input = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[] test = lcp.findDiagonalOrder(input);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_2() {
		Lcp_498_Diagonal_Traverse lcp = new Lcp_498_Diagonal_Traverse();
		
		int[] expect = { 1, 2, 3, 4 };
		int[][] input = { { 1, 2 }, { 3, 4 } };
		int[] test = lcp.findDiagonalOrder(input);
		
		assertThat(test).isEqualTo(expect);
	}
	
}
