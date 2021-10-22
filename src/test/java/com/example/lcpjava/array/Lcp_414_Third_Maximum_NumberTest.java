package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_414_Third_Maximum_NumberTest {
	
	@Test
	void test_case_1() {
		Lcp_414_Third_Maximum_Number lcp = new Lcp_414_Third_Maximum_Number();
		
		int expect = 1;
		int[] input = { 3, 2, 1 };
		int test = lcp.thirdMax(input);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_2() {
		Lcp_414_Third_Maximum_Number lcp = new Lcp_414_Third_Maximum_Number();
		
		int expect = 2;
		int[] input = { 1, 2 };
		int test = lcp.thirdMax(input);
		
		assertThat(test).isEqualTo(expect);
	}
	
	@Test
	void test_case_3() {
		Lcp_414_Third_Maximum_Number lcp = new Lcp_414_Third_Maximum_Number();
		
		int expect = 1;
		int[] input = { 2, 2, 3, 1 };
		int test = lcp.thirdMax(input);
		
		assertThat(test).isEqualTo(expect);
	}
	
}
