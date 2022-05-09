package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_1539_Kth_Missing_Positive_NumberTest {
	
	@Test
	void test_case_1() {
		Lcp_1539_Kth_Missing_Positive_Number lcp = new Lcp_1539_Kth_Missing_Positive_Number();
		
		int expected = 9;
		int[] arr = { 2, 3, 4, 7, 11 };
		int k = 5;
		int test = lcp.findKthPositive(arr, k);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_1539_Kth_Missing_Positive_Number lcp = new Lcp_1539_Kth_Missing_Positive_Number();
		
		int expected = 6;
		int[] arr = { 1, 2, 3, 4 };
		int k = 2;
		int test = lcp.findKthPositive(arr, k);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
