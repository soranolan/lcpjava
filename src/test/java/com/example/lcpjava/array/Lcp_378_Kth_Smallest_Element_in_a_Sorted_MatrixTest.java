package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_378_Kth_Smallest_Element_in_a_Sorted_MatrixTest {
	
	private Lcp_378_Kth_Smallest_Element_in_a_Sorted_Matrix lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_378_Kth_Smallest_Element_in_a_Sorted_Matrix();
	}
	
	@Test
	void test_case_1() {
		int expected = 13;
		int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
		int k = 8;
		int test = lcp.kthSmallest(matrix, k);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = -5;
		int[][] matrix = { { -5 } };
		int k = 1;
		int test = lcp.kthSmallest(matrix, k);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		int expected = 7;
		int[][] matrix = { { 1, 3, 7 }, { 5, 10, 12 }, { 6, 10, 15 } };
		int k = 5;
		int test = lcp.kthSmallest(matrix, k);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_4() {
		int expected = 10;
		int[][] matrix = { { 1, 3, 7 }, { 5, 10, 12 }, { 6, 10, 15 } };
		int k = 6;
		int test = lcp.kthSmallest(matrix, k);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
