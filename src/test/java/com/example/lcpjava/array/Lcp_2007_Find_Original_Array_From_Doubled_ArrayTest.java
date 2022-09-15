package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_2007_Find_Original_Array_From_Doubled_ArrayTest {
	
	private Lcp_2007_Find_Original_Array_From_Doubled_Array lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_2007_Find_Original_Array_From_Doubled_Array();
	}
	
	@Test
	void test_case_1() {
		int[] expected = { 1, 3, 4 };
		int[] changed = { 1, 3, 4, 2, 6, 8 };
		int[] test = lcp.findOriginalArray(changed);
		
		assertThat(test).containsExactlyInAnyOrder(expected);
	}
	
	@Test
	void test_case_2() {
		int[] expected = {};
		int[] changed = { 6, 3, 0, 1 };
		int[] test = lcp.findOriginalArray(changed);
		
		assertThat(test).containsExactlyInAnyOrder(expected);
	}
	
	@Test
	void test_case_3() {
		int[] expected = {};
		int[] changed = { 1 };
		int[] test = lcp.findOriginalArray(changed);
		
		assertThat(test).containsExactlyInAnyOrder(expected);
	}
	
	@Test
	void test_case_4() {
		int[] expected = {};
		int[] changed = { 0 };
		int[] test = lcp.findOriginalArray(changed);
		
		assertThat(test).containsExactlyInAnyOrder(expected);
	}
	
	@Test
	void test_case_5() {
		int[] expected = {};
		int[] changed = { 0, 0, 1, 0 };
		int[] test = lcp.findOriginalArray(changed);
		
		assertThat(test).containsExactlyInAnyOrder(expected);
	}
	
}
