package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_1089_Duplicate_ZerosTest {
	
	@Test
	void test_case_1() {
		Lcp_1089_Duplicate_Zeros lcp = new Lcp_1089_Duplicate_Zeros();
		
		int[] expected = { 1, 0, 0, 2, 3, 0, 0, 4 };
		int[] test = { 1, 0, 2, 3, 0, 4, 5, 0 };
		lcp.duplicateZeros(test);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_1089_Duplicate_Zeros lcp = new Lcp_1089_Duplicate_Zeros();
		
		int[] expected = { 1, 2, 3 };
		int[] test = { 1, 2, 3 };
		lcp.duplicateZeros(test);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_1089_Duplicate_Zeros lcp = new Lcp_1089_Duplicate_Zeros();
		
		int[] expected = { 0, 0, 0, 0, 0, 0, 0 };
		int[] test = { 0, 0, 0, 0, 0, 0, 0 };
		lcp.duplicateZeros(test);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
