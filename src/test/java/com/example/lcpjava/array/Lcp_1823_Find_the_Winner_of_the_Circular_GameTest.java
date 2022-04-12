package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_1823_Find_the_Winner_of_the_Circular_GameTest {
	
	@Test
	void test_case_1() {
		Lcp_1823_Find_the_Winner_of_the_Circular_Game lcp = new Lcp_1823_Find_the_Winner_of_the_Circular_Game();
		
		int expected = 3;
		int n = 5;
		int k = 2;
		int test = lcp.findTheWinner(n, k);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_1823_Find_the_Winner_of_the_Circular_Game lcp = new Lcp_1823_Find_the_Winner_of_the_Circular_Game();
		
		int expected = 1;
		int n = 6;
		int k = 5;
		int test = lcp.findTheWinner(n, k);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
