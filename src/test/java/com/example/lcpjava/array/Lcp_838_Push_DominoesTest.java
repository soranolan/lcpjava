package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_838_Push_DominoesTest {
	
	private Lcp_838_Push_Dominoes lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_838_Push_Dominoes();
	}
	
	@Test
	void test_case_1() {
		String expected = "RR.L";
		String dominoes = "RR.L";
		String test = lcp.pushDominoes(dominoes);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		String expected = "LL.RR.LLRRLL..";
		String dominoes = ".L.R...LR..L..";
		String test = lcp.pushDominoes(dominoes);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_3() {
		String expected = "R.LLL";
		String dominoes = "R.L.L";
		String test = lcp.pushDominoes(dominoes);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
