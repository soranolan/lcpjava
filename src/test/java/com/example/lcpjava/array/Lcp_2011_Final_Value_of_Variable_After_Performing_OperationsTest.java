package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_2011_Final_Value_of_Variable_After_Performing_OperationsTest {
	
	@Test
	void test_case_1() {
		Lcp_2011_Final_Value_of_Variable_After_Performing_Operations lcp = new Lcp_2011_Final_Value_of_Variable_After_Performing_Operations();
		
		int expected = 1;
		String[] input = { "--X", "X++", "X++" };
		int test = lcp.finalValueAfterOperations(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_2011_Final_Value_of_Variable_After_Performing_Operations lcp = new Lcp_2011_Final_Value_of_Variable_After_Performing_Operations();
		
		int expected = 3;
		String[] input = { "++X", "++X", "X++" };
		int test = lcp.finalValueAfterOperations(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_2011_Final_Value_of_Variable_After_Performing_Operations lcp = new Lcp_2011_Final_Value_of_Variable_After_Performing_Operations();
		
		int expected = 0;
		String[] input = { "X++", "++X", "--X", "X--" };
		int test = lcp.finalValueAfterOperations(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
