package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_977_Squares_of_a_Sorted_ArrayTest {
	
	@Test
	void test_case_1() {
		Lcp_977_Squares_of_a_Sorted_Array lcp = new Lcp_977_Squares_of_a_Sorted_Array();
		
		int[] expect = { 0, 1, 9, 16, 100 };
		int[] input = { -4, -1, 0, 3, 10 };
		int[] test = lcp.sortedSquares(input);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_2() {
		Lcp_977_Squares_of_a_Sorted_Array lcp = new Lcp_977_Squares_of_a_Sorted_Array();
		
		int[] expect = { 4, 9, 9, 49, 121 };
		int[] input = { -7, -3, 2, 3, 11 };
		int[] test = lcp.sortedSquares(input);
		
		assertThat(test).isEqualTo(expect);
	}
	
}
