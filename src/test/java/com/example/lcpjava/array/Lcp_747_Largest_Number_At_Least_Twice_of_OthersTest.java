package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_747_Largest_Number_At_Least_Twice_of_OthersTest {
	
	@Test
	void test_case_1() {
		Lcp_747_Largest_Number_At_Least_Twice_of_Others lcp = new Lcp_747_Largest_Number_At_Least_Twice_of_Others();
		
		int expected = 1;
		int[] input = { 3, 6, 1, 0 };
		int test = lcp.dominantIndex(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_747_Largest_Number_At_Least_Twice_of_Others lcp = new Lcp_747_Largest_Number_At_Least_Twice_of_Others();
		
		int expected = -1;
		int[] input = { 1, 2, 3, 4 };
		int test = lcp.dominantIndex(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_747_Largest_Number_At_Least_Twice_of_Others lcp = new Lcp_747_Largest_Number_At_Least_Twice_of_Others();
		
		int expected = 0;
		int[] input = { 1 };
		int test = lcp.dominantIndex(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
