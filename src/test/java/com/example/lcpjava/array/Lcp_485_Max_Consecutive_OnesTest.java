package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_485_Max_Consecutive_OnesTest {
	
	@Test
	void test_case_1() {
		Lcp_485_Max_Consecutive_Ones lcp = new Lcp_485_Max_Consecutive_Ones();
		
		int expect = 3;
		int[] input = { 1, 1, 0, 1, 1, 1 };
		int test = lcp.findMaxConsecutiveOnes(input);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_2() {
		Lcp_485_Max_Consecutive_Ones lcp = new Lcp_485_Max_Consecutive_Ones();
		
		int expect = 2;
		int[] input = { 1, 0, 1, 1, 0, 1 };
		int test = lcp.findMaxConsecutiveOnes(input);
		
		assertThat(test).isEqualTo(expect);
	}
	
}
