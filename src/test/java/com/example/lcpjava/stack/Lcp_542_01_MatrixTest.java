package com.example.lcpjava.stack;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_542_01_MatrixTest {
	
	@Test
	void test_case_1() {
		Lcp_542_01_Matrix lcp = new Lcp_542_01_Matrix();
		
		int[][] expected = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		
		int[][] input = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		int[][] test = lcp.updateMatrix(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_542_01_Matrix lcp = new Lcp_542_01_Matrix();
		
		int[][] expected = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 2, 1 } };
		
		int[][] input = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
		int[][] test = lcp.updateMatrix(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_542_01_Matrix lcp = new Lcp_542_01_Matrix();
		
		int[][] expected = { { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 } };
		
		int[][] input = { { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 } };
		int[][] test = lcp.updateMatrix(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
