package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_1295_Find_Numbers_with_Even_Number_of_DigitsTest {
	
	@Test
	void test_case_1() {
		Lcp_1295_Find_Numbers_with_Even_Number_of_Digits lcp = new Lcp_1295_Find_Numbers_with_Even_Number_of_Digits();
		
		int expected = 2;
		int[] input = { 12, 345, 2, 6, 7896 };
		int test = lcp.findNumbers(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_1295_Find_Numbers_with_Even_Number_of_Digits lcp = new Lcp_1295_Find_Numbers_with_Even_Number_of_Digits();
		
		int expected = 1;
		int[] input = { 555, 901, 482, 1771 };
		int test = lcp.findNumbers(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
