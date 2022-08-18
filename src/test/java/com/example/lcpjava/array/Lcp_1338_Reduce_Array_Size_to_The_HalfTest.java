package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_1338_Reduce_Array_Size_to_The_HalfTest {
	
	private Lcp_1338_Reduce_Array_Size_to_The_Half lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_1338_Reduce_Array_Size_to_The_Half();
	}
	
	@Test
	void test_case_1() {
		int expected = 2;
		int[] arr = { 3, 3, 3, 3, 5, 5, 5, 2, 2, 7 };
		int test = lcp.minSetSize(arr);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = 1;
		int[] arr = { 7, 7, 7, 7, 7, 7 };
		int test = lcp.minSetSize(arr);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		int expected = 5;
		int[] arr = { 9, 77, 63, 22, 92, 9, 14, 54, 8, 38, 18, 19, 38, 68, 58, 19 };
		int test = lcp.minSetSize(arr);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
