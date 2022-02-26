package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_406_Queue_Reconstruction_by_HeightTest {
	
	@Test
	void test_case_1() {
		Lcp_406_Queue_Reconstruction_by_Height lcp = new Lcp_406_Queue_Reconstruction_by_Height();
		
		int[][] expected = { { 5, 0 }, { 7, 0 }, { 5, 2 }, { 6, 1 }, { 4, 4 }, { 7, 1 } };
		int[][] input = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
		int[][] test = lcp.reconstructQueue(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_406_Queue_Reconstruction_by_Height lcp = new Lcp_406_Queue_Reconstruction_by_Height();
		
		int[][] expected = { { 4, 0 }, { 5, 0 }, { 2, 2 }, { 3, 2 }, { 1, 4 }, { 6, 0 } };
		int[][] input = { { 6, 0 }, { 5, 0 }, { 4, 0 }, { 3, 2 }, { 2, 2 }, { 1, 4 } };
		int[][] test = lcp.reconstructQueue(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_406_Queue_Reconstruction_by_Height lcp = new Lcp_406_Queue_Reconstruction_by_Height();
		
		int[][] expected = { { 3, 0 }, { 8, 0 }, { 6, 1 }, { 4, 2 } };
		int[][] input = { { 3, 0 }, { 4, 2 }, { 6, 1 }, { 8, 0 } };
		int[][] test = lcp.reconstructQueue(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
