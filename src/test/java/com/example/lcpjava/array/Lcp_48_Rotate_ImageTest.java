package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_48_Rotate_ImageTest {
	
	@Test
	void test_case_1() {
		Lcp_48_Rotate_Image lcp = new Lcp_48_Rotate_Image();
		
		int[][] expected = { { 7, 4, 1 }, { 8, 5, 2 }, { 9, 6, 3 } };
		int[][] test = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		lcp.rotate(test);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_48_Rotate_Image lcp = new Lcp_48_Rotate_Image();
		
		int[][] expected = { { 15, 13, 2, 5 }, { 14, 3, 4, 1 }, { 12, 6, 8, 9 }, { 16, 7, 10, 11 } };
		int[][] test = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
		lcp.rotate(test);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_48_Rotate_Image lcp = new Lcp_48_Rotate_Image();
		
		int[][] expected = { { 21, 16, 11, 6, 1 }, { 22, 17, 12, 7, 2 }, { 23, 18, 13, 8, 3 }, { 24, 19, 14, 9, 4 }, { 25, 20, 15, 10, 5 } };
		int[][] test = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 }, { 21, 22, 23, 24, 25 } };
		lcp.rotate(test);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
