package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_189_Rotate_ArrayTest {
	
	@Test
	void test_case_1() {
		Lcp_189_Rotate_Array lcp = new Lcp_189_Rotate_Array();
		
		int[] expected = { 5, 6, 7, 1, 2, 3, 4 };
		int[] test = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		lcp.rotate(test, k);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_189_Rotate_Array lcp = new Lcp_189_Rotate_Array();
		
		int[] expected = { 3, 99, -1, -100 };
		int[] test = { -1, -100, 3, 99 };
		int k = 2;
		lcp.rotate(test, k);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
