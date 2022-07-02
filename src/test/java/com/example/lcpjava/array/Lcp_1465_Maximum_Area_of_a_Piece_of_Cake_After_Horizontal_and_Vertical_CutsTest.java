package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_1465_Maximum_Area_of_a_Piece_of_Cake_After_Horizontal_and_Vertical_CutsTest {
	
	private Lcp_1465_Maximum_Area_of_a_Piece_of_Cake_After_Horizontal_and_Vertical_Cuts lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_1465_Maximum_Area_of_a_Piece_of_Cake_After_Horizontal_and_Vertical_Cuts();
	}
	
	@Test
	void test_case_1() {
		int expected = 4;
		int h = 5;
		int w = 4;
		int[] horizontalCuts = { 1, 2, 4 };
		int[] verticalCuts = { 1, 3 };
		int test = lcp.maxArea(h, w, horizontalCuts, verticalCuts);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = 6;
		int h = 5;
		int w = 4;
		int[] horizontalCuts = { 3, 1 };
		int[] verticalCuts = { 1 };
		int test = lcp.maxArea(h, w, horizontalCuts, verticalCuts);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		int expected = 9;
		int h = 5;
		int w = 4;
		int[] horizontalCuts = { 3 };
		int[] verticalCuts = { 3 };
		int test = lcp.maxArea(h, w, horizontalCuts, verticalCuts);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_4() {
		int expected = 81;
		int h = 1000000000;
		int w = 1000000000;
		int[] horizontalCuts = { 2 };
		int[] verticalCuts = { 2 };
		int test = lcp.maxArea(h, w, horizontalCuts, verticalCuts);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
