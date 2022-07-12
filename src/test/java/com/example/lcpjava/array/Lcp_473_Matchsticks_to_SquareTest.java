package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lcp_473_Matchsticks_to_SquareTest {
	
	private Lcp_473_Matchsticks_to_Square lcp;
	
	@BeforeEach
	void beforeEach() {
		lcp = new Lcp_473_Matchsticks_to_Square();
	}
	
	@Test
	void test_case_1() {
		int[] matchsticks = { 1, 1, 2, 2, 2 };
		boolean test = lcp.makesquare(matchsticks);
		
		assertThat(test).isTrue();
	}
	
	@Test
	void test_case_2() {
		int[] matchsticks = { 3, 3, 3, 3, 4 };
		boolean test = lcp.makesquare(matchsticks);
		
		assertThat(test).isFalse();
	}
	
}
