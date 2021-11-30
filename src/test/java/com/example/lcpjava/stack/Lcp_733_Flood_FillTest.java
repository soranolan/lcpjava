package com.example.lcpjava.stack;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_733_Flood_FillTest {
	
	@Test
	void test_case_1() {
		Lcp_733_Flood_Fill lcp = new Lcp_733_Flood_Fill();
		
		int[][] expected = { { 2, 2, 2 }, { 2, 2, 0 }, { 2, 0, 1 } };
		
		int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		int sr = 1;
		int sc = 1;
		int newColor = 2;
		int[][] test = lcp.floodFill(image, sr, sc, newColor);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_733_Flood_Fill lcp = new Lcp_733_Flood_Fill();
		
		int[][] expected = { { 2, 2, 2 }, { 2, 2, 2 } };
		
		int[][] image = { { 0, 0, 0 }, { 0, 0, 0 } };
		int sr = 0;
		int sc = 0;
		int newColor = 2;
		int[][] test = lcp.floodFill(image, sr, sc, newColor);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_733_Flood_Fill lcp = new Lcp_733_Flood_Fill();
		
		int[][] expected = { { 0, 0, 0 }, { 0, 1, 1 } };
		
		int[][] image = { { 0, 0, 0 }, { 0, 1, 1 } };
		int sr = 1;
		int sc = 1;
		int newColor = 1;
		int[][] test = lcp.floodFill(image, sr, sc, newColor);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
