package com.example.lcpjava.dynamicprogramming;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_790_Domino_and_Tromino_TilingTest {
	
	private Lcp_790_Domino_and_Tromino_Tiling lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_790_Domino_and_Tromino_Tiling();
	}
	
	@Test
	void test_case_1() {
		int expected = 5;
		
		int n = 3;
		int test = lcp.numTilings(n);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		int expected = 1;
		
		int n = 1;
		int test = lcp.numTilings(n);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
