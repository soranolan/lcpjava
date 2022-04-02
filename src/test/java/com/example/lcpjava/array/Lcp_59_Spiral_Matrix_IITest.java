package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_59_Spiral_Matrix_IITest {
	
	@Test
	void test_case_1() {
		Lcp_59_Spiral_Matrix_II lcp = new Lcp_59_Spiral_Matrix_II();
		
		int[][] expected = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
		int input = 3;
		int[][] test = lcp.generateMatrix(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_59_Spiral_Matrix_II lcp = new Lcp_59_Spiral_Matrix_II();
		
		int[][] expected = { { 1 } };
		int input = 1;
		int[][] test = lcp.generateMatrix(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
