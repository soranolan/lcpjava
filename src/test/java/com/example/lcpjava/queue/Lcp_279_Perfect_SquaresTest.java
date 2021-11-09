package com.example.lcpjava.queue;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_279_Perfect_SquaresTest {
	
	@Test
	void test_case_1() {
		Lcp_279_Perfect_Squares lcp = new Lcp_279_Perfect_Squares();
		
		int expected = 3;
		int input = 12;
		int test = -1;
		
		test = lcp.numSquares(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_279_Perfect_Squares lcp = new Lcp_279_Perfect_Squares();
		
		int expected = 2;
		int input = 13;
		int test = -1;
		
		test = lcp.numSquares(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		Lcp_279_Perfect_Squares lcp = new Lcp_279_Perfect_Squares();
		
		int expected = 4;
		int input = 7;
		int test = -1;
		
		test = lcp.numSquares(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
