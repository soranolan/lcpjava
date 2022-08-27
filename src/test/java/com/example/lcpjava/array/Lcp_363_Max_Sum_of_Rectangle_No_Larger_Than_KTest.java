package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_363_Max_Sum_of_Rectangle_No_Larger_Than_KTest {
	
	private Lcp_363_Max_Sum_of_Rectangle_No_Larger_Than_K lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_363_Max_Sum_of_Rectangle_No_Larger_Than_K();
	}
	
	@Test
	void test_case_1() {
		int expected = 2;
		int[][] matrix = { { 1, 0, 1 }, { 0, -2, 3 } };
		int k = 2;
		int test = lcp.maxSumSubmatrix(matrix, k);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = 3;
		int[][] matrix = { { 2, 2, -1 } };
		int k = 3;
		int test = lcp.maxSumSubmatrix(matrix, k);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		int expected = 2;
		int[][] matrix = { { 2, 2, -1 } };
		int k = 2;
		int test = lcp.maxSumSubmatrix(matrix, k);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_4() {
		int expected = -1;
		int[][] matrix = { { 2, 2, -1 } };
		int k = 0;
		int test = lcp.maxSumSubmatrix(matrix, k);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_5() {
		int expected = 10;
		int[][] matrix = { { 5, -4, -3, 4 }, { -3, -4, 4, 5 }, { 5, 1, 5, -4 } };
		int k = 10;
		int test = lcp.maxSumSubmatrix(matrix, k);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
