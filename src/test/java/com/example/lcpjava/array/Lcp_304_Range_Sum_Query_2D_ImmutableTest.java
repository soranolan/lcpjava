package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_304_Range_Sum_Query_2D_ImmutableTest {
	
	@Test
	void test_case_1() {
		int expected = -1;
		int test = -1;
		int[][] matrix = {
				{ 3, 0, 1, 4, 2 },
				{ 5, 6, 3, 2, 1 },
				{ 1, 2, 0, 1, 5 },
				{ 4, 1, 0, 1, 7 },
				{ 1, 0, 3, 0, 5 }
		};
		NumMatrix obj = new NumMatrix(matrix);
		
		expected = 8;
		test = obj.sumRegion(2, 1, 4, 3);
		assertThat(test).isEqualTo(expected);
		
		expected = 11;
		test = obj.sumRegion(1, 1, 2, 2);
		assertThat(test).isEqualTo(expected);
		
		expected = 12;
		test = obj.sumRegion(1, 2, 2, 4);
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = -1;
		int test = -1;
		int[][] matrix = {
				{ -4, -5 },
		};
		NumMatrix obj = new NumMatrix(matrix);
		
		expected = -4;
		test = obj.sumRegion(0, 0, 0, 0);
		assertThat(test).isEqualTo(expected);
		
		expected = -9;
		test = obj.sumRegion(0, 0, 0, 1);
		assertThat(test).isEqualTo(expected);
		
		expected = -5;
		test = obj.sumRegion(0, 1, 0, 1);
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		int expected = -1;
		int test = -1;
		int[][] matrix = {
				{ 1 },
				{ -7 },
		};
		NumMatrix obj = new NumMatrix(matrix);
		
		expected = 1;
		test = obj.sumRegion(0, 0, 0, 0);
		assertThat(test).isEqualTo(expected);
		
		expected = -7;
		test = obj.sumRegion(1, 0, 1, 0);
		assertThat(test).isEqualTo(expected);
		
		expected = -6;
		test = obj.sumRegion(0, 0, 1, 0);
		assertThat(test).isEqualTo(expected);
	}
	
}
