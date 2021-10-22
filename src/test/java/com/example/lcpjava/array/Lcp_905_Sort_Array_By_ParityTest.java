package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_905_Sort_Array_By_ParityTest {
	
	@Test
	void test_case_1() {
		Lcp_905_Sort_Array_By_Parity lcp = new Lcp_905_Sort_Array_By_Parity();
		
		int[] expect = { 2, 4, 3, 1 };
		int[] input = { 3, 1, 2, 4 };
		int[] test = lcp.sortArrayByParity(input);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_2() {
		Lcp_905_Sort_Array_By_Parity lcp = new Lcp_905_Sort_Array_By_Parity();
		
		int[] expect = { 0 };
		int[] input = { 0 };
		int[] test = lcp.sortArrayByParity(input);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_3() {
		Lcp_905_Sort_Array_By_Parity lcp = new Lcp_905_Sort_Array_By_Parity();
		
		int[] expect = { 0, 2, 1 };
		int[] input = { 0, 1, 2 };
		int[] test = lcp.sortArrayByParity(input);
		
		assertThat(test).isEqualTo(expect);
	}
	
}
