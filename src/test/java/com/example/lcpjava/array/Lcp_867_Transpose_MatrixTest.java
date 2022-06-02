package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_867_Transpose_MatrixTest {
	
	private Lcp_867_Transpose_Matrix lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_867_Transpose_Matrix();
	}
	
	@Test
	void test_case_1() {
		int[][] expected = { { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 } };
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] test = lcp.transpose(matrix);
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int[][] expected = { { 1, 4 }, { 2, 5 }, { 3, 6 } };
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] test = lcp.transpose(matrix);
		assertThat(test).isEqualTo(expected);
	}
	
}
