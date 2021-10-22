package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_941_Valid_Mountain_ArrayTest {
	
	@Test
	void test_case_1() {
		Lcp_941_Valid_Mountain_Array lcp = new Lcp_941_Valid_Mountain_Array();
		
		int[] input = { 2, 1 };
		boolean test = lcp.validMountainArray(input);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_2() {
		Lcp_941_Valid_Mountain_Array lcp = new Lcp_941_Valid_Mountain_Array();
		
		int[] input = { 3, 5, 5 };
		boolean test = lcp.validMountainArray(input);
		
		assertThat(test).isFalse();
	}
	
	@Test
	void test_case_3() {
		Lcp_941_Valid_Mountain_Array lcp = new Lcp_941_Valid_Mountain_Array();
		
		int[] input = { 0, 3, 2, 1 };
		boolean test = lcp.validMountainArray(input);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_4() {
		Lcp_941_Valid_Mountain_Array lcp = new Lcp_941_Valid_Mountain_Array();
		
		int[] input = { 2, 0, 2 };
		boolean test = lcp.validMountainArray(input);
		
		assertThat(test).isFalse();
	}
	
}
