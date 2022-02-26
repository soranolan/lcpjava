package com.example.lcpjava.greedy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_1414_Find_the_Minimum_Number_of_Fibonacci_Numbers_Whose_Sum_Is_KTest {
	
	@Test
	void test_case_1() {
		Lcp_1414_Find_the_Minimum_Number_of_Fibonacci_Numbers_Whose_Sum_Is_K lcp = new Lcp_1414_Find_the_Minimum_Number_of_Fibonacci_Numbers_Whose_Sum_Is_K();
		
		int expected = 2;
		int k = 7;
		int test = lcp.findMinFibonacciNumbers(k);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_1414_Find_the_Minimum_Number_of_Fibonacci_Numbers_Whose_Sum_Is_K lcp = new Lcp_1414_Find_the_Minimum_Number_of_Fibonacci_Numbers_Whose_Sum_Is_K();
		
		int expected = 2;
		int k = 10;
		int test = lcp.findMinFibonacciNumbers(k);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_1414_Find_the_Minimum_Number_of_Fibonacci_Numbers_Whose_Sum_Is_K lcp = new Lcp_1414_Find_the_Minimum_Number_of_Fibonacci_Numbers_Whose_Sum_Is_K();
		
		int expected = 3;
		int k = 19;
		int test = lcp.findMinFibonacciNumbers(k);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_4() {
		Lcp_1414_Find_the_Minimum_Number_of_Fibonacci_Numbers_Whose_Sum_Is_K lcp = new Lcp_1414_Find_the_Minimum_Number_of_Fibonacci_Numbers_Whose_Sum_Is_K();
		
		int expected = 11;
		int k = 513314;
		int test = lcp.findMinFibonacciNumbers(k);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
