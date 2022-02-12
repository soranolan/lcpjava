package com.example.lcpjava.heap;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_1337_The_K_Weakest_Rows_in_a_MatrixTest {
	
	@Test
	void test_case_1() {
		Lcp_1337_The_K_Weakest_Rows_in_a_Matrix lcp = new Lcp_1337_The_K_Weakest_Rows_in_a_Matrix();
		
		int[] expected = { 2, 0, 3 };
		int k = 3;
		int[][] mat = new int[][] {
			{ 1, 1, 0, 0, 0 },
			{ 1, 1, 1, 1, 0 },
			{ 1, 0, 0, 0, 0 },
			{ 1, 1, 0, 0, 0 },
			{ 1, 1, 1, 1, 1 }
		};
		int[] test = lcp.kWeakestRows(mat, k);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_1337_The_K_Weakest_Rows_in_a_Matrix lcp = new Lcp_1337_The_K_Weakest_Rows_in_a_Matrix();
		
		int[] expected = { 0, 2 };
		int k = 2;
		int[][] mat = new int[][] {
			{ 1, 0, 0, 0 },
			{ 1, 1, 1, 1 },
			{ 1, 0, 0, 0 },
			{ 1, 0, 0, 0 },
		};
		int[] test = lcp.kWeakestRows(mat, k);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_1337_The_K_Weakest_Rows_in_a_Matrix lcp = new Lcp_1337_The_K_Weakest_Rows_in_a_Matrix();
		
		int[] expected = { 1, 0 };
		int k = 2;
		int[][] mat = new int[][] {
			{ 1, 0 },
			{ 0, 0 },
			{ 1, 0 },
		};
		int[] test = lcp.kWeakestRows(mat, k);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
