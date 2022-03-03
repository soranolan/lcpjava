package com.example.lcpjava.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_1140_Stone_Game_IITest {
	
	@Test
	void test_case_1() {
		Lcp_1140_Stone_Game_II lcp = new Lcp_1140_Stone_Game_II();
		
		int expected = 10;
		int[] input = { 2, 7, 9, 4, 4 };
		int test = lcp.stoneGameII(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
	@Test
	void test_case_2() {
		Lcp_1140_Stone_Game_II lcp = new Lcp_1140_Stone_Game_II();
		
		int expected = 104;
		int[] input = { 1, 2, 3, 4, 5, 100 };
		int test = lcp.stoneGameII(input);
		
		assertThat(test).isEqualTo(expected);
	}
	
}
