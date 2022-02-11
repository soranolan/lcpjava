package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_661_Image_SmootherTest {
	
	@Test
	void test_case_1() {
		Lcp_661_Image_Smoother lcp = new Lcp_661_Image_Smoother();
		
		int[][] expected = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		int[][] input = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		int[][] test = lcp.imageSmoother(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_661_Image_Smoother lcp = new Lcp_661_Image_Smoother();
		
		int[][] expected = { { 137, 141, 137 }, { 141, 138, 141 }, { 137, 141, 137 } };
		int[][] input = { { 100, 200, 100 }, { 200, 50, 200 }, { 100, 200, 100 } };
		int[][] test = lcp.imageSmoother(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
