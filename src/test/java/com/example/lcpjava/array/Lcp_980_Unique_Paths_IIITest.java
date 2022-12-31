package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_980_Unique_Paths_IIITest {
	
	private Lcp_980_Unique_Paths_III lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_980_Unique_Paths_III();
	}
	
	@Test
	void test_case_1() {
		int expected = 2;
		int[][] grid = { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 2, -1 } };
		int test = lcp.uniquePathsIII(grid);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = 4;
		int[][] grid = { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 2 } };
		int test = lcp.uniquePathsIII(grid);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		int expected = 0;
		int[][] grid = { { 0, 1 }, { 2, 0 } };
		int test = lcp.uniquePathsIII(grid);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
